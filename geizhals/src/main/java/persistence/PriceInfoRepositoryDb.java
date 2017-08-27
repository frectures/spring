package persistence;

import java.util.Random;

public class PriceInfoRepositoryDb extends RepositoryDb<PriceInfo> {
	private static final String[] initialDiscounters = { "All Die", "Liedel", "Penner" };
	private static final Random rng = new Random();

	{
		saveRandomPriceInfos("Milch", 60, 90);
		saveRandomPriceInfos("Rundkornreis", 50, 200);
		saveRandomPriceInfos("Apfelmus", 80, 150);
		saveRandomPriceInfos("Zimt", 40, 100);
	}

	private void saveRandomPriceInfos(String product, int lowerBound, int upperBound) {
		for (String discounter : initialDiscounters) {
			save(new PriceInfo(product, discounter, randomPrice(lowerBound, upperBound)));
		}
	}

	private int randomPrice(int lowerPriceBound, int upperPriceBound) {
		return lowerPriceBound + rng.nextInt(upperPriceBound - lowerPriceBound);
	}
}
