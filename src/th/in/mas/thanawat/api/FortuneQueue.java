package th.in.mas.thanawat.api;

import io.reactivex.Observable;

import java.util.Date;

public class FortuneQueue implements Api {
    private int entryNo;
    private Date entryTime;
    private int luckyScale;

    public static Observable<Api> mockApi() {
        FortuneQueue queue = new FortuneQueue();
        queue.setEntryNo(25);
        queue.setEntryTime(new Date(System.currentTimeMillis()));
        queue.setLuckyScale(5);

        return Observable.just(queue);
    }

    public int getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(int entryNo) {
        this.entryNo = entryNo;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public int getLuckyScale() {
        return luckyScale;
    }

    public void setLuckyScale(int luckyScale) {
        this.luckyScale = luckyScale;
    }

    @Override
    public String getApiName() {
        return getClass().getSimpleName();
    }
}
