package mz.co.gym.controller.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mz.co.gym.models.PaymentEntity;
import mz.co.gym.models.PaymentMethod;
import mz.co.gym.models.PaymentType;
import mz.co.gym.services.ICustomerService;

public class Utility {

	private static Utility instance = new Utility();

	public static Utility getInstance() {
		return instance;
	}

	public Map<Long, List<PaymentEntity>> groupByMonth(List<PaymentEntity> payments) {

		Map<Long, List<PaymentEntity>> paymentsMap = new HashMap<>();

		for (PaymentEntity paymentEntity : payments) {

			Long month = paymentEntity.getMonth();

			List<PaymentEntity> paymentsList = paymentsMap.get(month);
			if (paymentsList == null) {

				paymentsMap.put(month, new ArrayList<>());
			}
			paymentsMap.get(month).add(paymentEntity);
		}
		return paymentsMap;

	}

	public Map<String, Object> addAttributes(ICustomerService customerService) {
		Map<String, Object> map = new HashMap<>();
		map.put("paymentTypes", PaymentType.values());
		map.put("paymentMethods", PaymentMethod.values());
		map.put("customers", customerService.findAll());
		map.put("payment", new PaymentEntity());

		return map;
	}

	Map<Long, String> getMonth() {

		Map<Long, String> monthUtils = new HashMap<>();
		monthUtils.put(1L, "Janeiro");
		monthUtils.put(2L, "Fevereiro");
		monthUtils.put(3L, "Março");
		monthUtils.put(4L, "Abril");
		monthUtils.put(5L, "Maio");
		monthUtils.put(6L, "Junho");
		monthUtils.put(7L, "Julho");
		monthUtils.put(8L, "Agosto");
		monthUtils.put(9L, "Setembro");
		monthUtils.put(10L, "Outubro");
		monthUtils.put(11L, "Novembro");
		monthUtils.put(12L, "Dezembro");

		return monthUtils;
	}

}
