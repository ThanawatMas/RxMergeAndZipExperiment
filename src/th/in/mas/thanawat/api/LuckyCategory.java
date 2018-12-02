package th.in.mas.thanawat.api;

import io.reactivex.Observable;

import java.util.concurrent.Callable;

public class LuckyCategory implements Api {
    private String category;
    private int entryNo;
    private double discountRate;

    public static Observable<Api> mockApi() {
        LuckyCategory luckyCategory = new LuckyCategory();
        luckyCategory.setCategory("Shoe");
        luckyCategory.setEntryNo(25);
        luckyCategory.setDiscountRate(10.5);
        return Observable.just(luckyCategory);
    }

    public static Observable<Api> mockFailedApi() {
        return Observable.fromCallable(() -> {
            throw new RuntimeException("Unexpected Exception!!!! on LuckyCategory.mockFailedApi()");
        });
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(int entryNo) {
        this.entryNo = entryNo;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String getApiName() {
        return getClass().getSimpleName();
    }
}
