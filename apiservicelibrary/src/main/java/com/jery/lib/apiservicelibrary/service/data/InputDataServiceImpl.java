package com.jery.lib.apiservicelibrary.service.data;

import com.jery.lib.networklibrary.callback.RequestCallBack;
import com.jery.lib.networklibrary.service.ServiceExecutor;
import com.jery.lib.networklibrary.service.ServiceGenerator;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class InputDataServiceImpl {

    private static InputDataServiceImpl instance;

    private InputDataServiceImpl() {
    }

    public static InputDataServiceImpl getInstance() {
        if (instance == null) {
            synchronized (InputDataServiceImpl.class) {
                if (instance == null)
                    instance = new InputDataServiceImpl();
            }
        }
        return instance;
    }

    public void getInputData(@NotNull String user, RequestCallBack callBack) {
        InputDataService inputDataService = ServiceGenerator.createService(InputDataService.class);
        HashMap<String, Object> params = InputDataParamsMaker.getInputDataParams(user);
        ServiceExecutor.getInstance().execute(inputDataService.getInputDataInfo(params), callBack);

    }
}
