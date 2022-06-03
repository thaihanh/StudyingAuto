package entity;

public class DiscountRate {

    private static double serviceDiscountPremium = 0.2;
    private static double serviceDiscountGold= 0.15;
    private static double serviceDiscountSliver = 0.1;
    private static double productDiscountPremium = 0.1;
    private static double productDiscountGold = 0.1;
    private static double productDiscountSliver = 0.1;

    public static double getServiceDiscountRate(String type){
        switch (type){
            case "Premium":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountGold;
            case "Sliver":
                return serviceDiscountSliver;
        }
        return 0;
    }
    public static double getProductDiscountRate(String type){
        switch (type){
            case "Premium":
                return productDiscountPremium;
            case "Gold":
                return productDiscountGold;
            case "Sliver":
                return productDiscountSliver;
        }
        return 0;
    }

}
