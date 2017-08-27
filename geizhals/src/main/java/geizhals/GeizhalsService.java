package geizhals;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import persistence.PriceInfo;
import persistence.Repository;

@Service
public class GeizhalsService {
	private final Repository<PriceInfo> priceInfos;

	public GeizhalsService(Repository<PriceInfo> priceInfos) {
		this.priceInfos = priceInfos;
	}

	public List<PriceInfo> allPriceInfos() {
		return priceInfos.findAll();
	}

	public List<String> allProducts() {
		return allPriceInfos().stream().map(PriceInfo::getProduct).distinct().collect(toList());
	}

	public List<String> allDiscounters() {
		return allPriceInfos().stream().map(PriceInfo::getDiscounter).distinct().collect(toList());
	}

	public Map<String, Map<String, PriceInfo>> allPriceInfosByProductAndDiscounter() {
		return allPriceInfos().stream()
				.collect(groupingBy(PriceInfo::getProduct, toMap(PriceInfo::getDiscounter, Function.identity())));
	}

	public Map<String, PriceInfo> cheapestPriceInfosByProduct() {
		return allPriceInfos().stream()
				.collect(toMap(PriceInfo::getProduct, Function.identity(), GeizhalsService::betterPrice));

	}

	private static PriceInfo betterPrice(PriceInfo a, PriceInfo b) {
		return (a.getPrice() < b.getPrice()) ? a : b;
	}
}
