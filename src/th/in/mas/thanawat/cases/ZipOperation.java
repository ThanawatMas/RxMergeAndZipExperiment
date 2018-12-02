package th.in.mas.thanawat.cases;

import io.reactivex.Observable;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import th.in.mas.thanawat.api.FortuneQueue;
import th.in.mas.thanawat.api.LuckyCategory;
import th.in.mas.thanawat.api.UserProfile;

public class ZipOperation implements RxOperationCase {
    @Override
    public void runSmoothAtSilk() {
        String TAG = "ZipOperation.runSmoothAtSilk";
        System.out.println(TAG + " START >>>>>> ");

        Observable.zip(UserProfile.mockApi(), LuckyCategory.mockApi(), FortuneQueue.mockApi(), (api, api2, api3) -> {
            //todo: Logic lucky person here!!
            System.out.println(TAG + " apply: " + api.getApiName() + ", " + api2.getApiName() + ", " + api3.getApiName());
            return "Object that mix data from call!!";
        })
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new ResourceObserver<Object>() {
                    @Override
                    public void onNext(Object result) {
                        System.out.println(TAG + " onNext: " + result);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(TAG + " onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(TAG + " onComplete!!!");
                    }
                });
    }

    @Override
    public void runStickWithProblem() {
        String TAG = "ZipOperation.runStickWithProblem";
        System.out.println(TAG + " START >>>>>> ");


        Observable.zip(UserProfile.mockApi(), LuckyCategory.mockFailedApi(), FortuneQueue.mockApi(), (api, api2, api3) -> {
            //todo: Logic lucky person here!!
            System.out.println(TAG + " apply: ");
            return "Object that mix data from call!!";
        })
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new ResourceObserver<Object>() {
                    @Override
                    public void onNext(Object result) {
                        System.out.println(TAG + " onNext: " + result);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(TAG + " onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(TAG + " onComplete!!!");
                    }
                });
    }
}
