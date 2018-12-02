package th.in.mas.thanawat.cases;

import io.reactivex.Observable;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import th.in.mas.thanawat.api.Api;
import th.in.mas.thanawat.api.FortuneQueue;
import th.in.mas.thanawat.api.LuckyCategory;
import th.in.mas.thanawat.api.UserProfile;

public class MergeOperation implements RxOperationCase {

    @Override
    public void runSmoothAtSilk() {
        String TAG = "MergeOperation.runSmoothAtSilk";

        System.out.println(TAG + " START >>>>>> ");

        Observable.merge(UserProfile.mockApi(), LuckyCategory.mockApi(), FortuneQueue.mockApi())
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new ResourceObserver<Api>() {
                    @Override
                    public void onNext(Api api) {
                        System.out.println(TAG + " onNext: " + api.getApiName());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(TAG + " onError: ");
                    }

                    @Override
                    public void onComplete() {
                        //todo: Logic lucky person here!!
                        System.out.println(TAG + " onComplete!!!");
                    }
                });
    }

    @Override
    public void runStickWithProblem() {
        String TAG = "MergeOperation.runStickWithProblem";
        System.out.println(TAG + " START >>>>>> ");

        Observable.merge(UserProfile.mockApi(), LuckyCategory.mockFailedApi(), FortuneQueue.mockApi())
                .subscribeOn(Schedulers.io())
                .subscribe(new ResourceObserver<Api>() {
                    @Override
                    public void onNext(Api api) {
                        System.out.println(TAG + " onNext: " + api.getApiName());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(TAG + " onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        //todo: Logic lucky person here!!
                        System.out.println(TAG + " onComplete!!!");
                    }
                });
    }
}
