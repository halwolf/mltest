package com.mercadolibre.demoapp.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadolibre.demoapp.dao.IIPBanList;
import com.mercadolibre.demoapp.dao.IIPRegisterLog;
import com.mercadolibre.demoapp.entity.CountryInfo;
import com.mercadolibre.demoapp.entity.Currency;
import com.mercadolibre.demoapp.entity.CurrencyInfo;
import com.mercadolibre.demoapp.entity.GeoLocIP;
import com.mercadolibre.demoapp.entity.IpBanList;
import com.mercadolibre.demoapp.entity.IpRegisterLog;
import com.mercadolibre.demoapp.exceptions.AlreadyExistException;
import com.mercadolibre.demoapp.exceptions.GeneralException;
import com.mercadolibre.demoapp.exceptions.ValidationException;
import com.mercadolibre.demoapp.response.Response;
import com.mercadolibre.demoapp.response.Result;
import com.mercadolibre.demoapp.restclient.impl.CountriesInfoClient;
import com.mercadolibre.demoapp.restclient.impl.GeoLocIPClient;
import com.mercadolibre.demoapp.restclient.impl.RatesCurrencyInfoClient;
import com.mercadolibre.demoapp.services.IIPAnalyserServices;
import com.mercadolibre.demoapp.utils.Constants;
import com.mercadolibre.demoapp.utils.Utils;

@Service
public class IPAnalyserServicesImpl implements IIPAnalyserServices {

	@Autowired
	CountriesInfoClient countryInfoClient;

	@Autowired
	GeoLocIPClient geoLocInfoClient;

	@Autowired
	RatesCurrencyInfoClient ratesInfoClient;

	@Autowired
	IIPBanList banList;

	@Autowired
	IIPRegisterLog registerLog;

	@Override
	public ResponseEntity getDataByIP(String ip) throws GeneralException {
		Response response = new Response(Constants.SUCCESS_MESSAGE);
		try {
			validateData(ip);

			IpRegisterLog latestRegister = getLatestRegister(ip);
			if (!Utils.inNull(latestRegister)) {
				response.setResult(latestRegister);
				return Utils.createResponse(response);
			}

			IpRegisterLog result = new IpRegisterLog();
			GeoLocIP geoLocIPInfo = geoLocInfoClient.getGeoLocDataByIP(ip);

			if (Utils.inNullOrEmpty(geoLocIPInfo.getCountryCode())) {
				String message = String.format(Constants.IP_NOT_FOUND, ip);
				throw new ValidationException(message);
			}

			result.setCountryCode(geoLocIPInfo.getCountryCode());
			result.setCountryName(geoLocIPInfo.getCountryName());

			CountryInfo countryInfo = countryInfoClient.getGeoLocDataByIP(geoLocIPInfo.getCountryCode());

			if (!Utils.isNullOrEmpty(countryInfo.getCurrencies())) {
				Currency currency = countryInfo.getCurrencies().get(0);
				String currencyCode = currency.getCode();
				result.setCurrency(currencyCode);

				CurrencyInfo currencyInfo = ratesInfoClient.getConvertCurrencyBySource(currencyCode);
				result.setRates(currencyInfo.getRates());
			}
			result.setIpOrigen(ip);

			response.setResult(result);

			saveLog(result);

			return Utils.createResponse(response);
		} catch (GeneralException ex) {
			return Utils.createResponse(ex);
		} catch (Exception ex2) {
			return Utils.createResponse(ex2);
		}

	}

	@Override
	public ResponseEntity banIp(String ip) throws GeneralException {
		try {

			validateData(ip);

			IpBanList ban = new IpBanList();
			ban.setIp(ip);

			saveBan(ban);
			String message = String.format(Constants.BLOCKED_IP, ip);
			return Utils.createResponse(message);

		} catch (GeneralException ex) {
			return Utils.createResponse(ex);
		} catch (Exception ex2) {
			return Utils.createResponse(ex2);
		}

	}

	public boolean existIPBan(String ip) {
		return !banList.findByIP(ip).isEmpty();
	}

	public IpRegisterLog getLatestRegister(String ip) {
		Date fromDate = Utils.getDateSubstract(-1);
		List<IpRegisterLog> result = registerLog.findByIP(ip, fromDate);
		return !Utils.isNullOrEmpty(result) ? result.get(0) : null;
	}

	public void saveLog(IpRegisterLog result) {
		registerLog.save(result);
	}

	public void saveBan(IpBanList ban) {
		banList.save(ban);
	}

	public void validateData(String ip) throws GeneralException {

		if (Utils.inNullOrEmpty(ip)) {
			throw new ValidationException(Constants.REQUIRED_IP);
		}

		if (!Utils.isIP(ip)) {
			throw new ValidationException(Constants.INVALID_FORMAT);
		}

		if (existIPBan(ip)) {
			String message = String.format(Constants.ALREADY_BLOCKED_IP, ip);
			throw new AlreadyExistException(message);
		}
	}

}
