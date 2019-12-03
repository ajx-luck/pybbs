package co.yiiu.pybbs.controller.zxj;


import co.yiiu.pybbs.controller.api.BaseApiController;

public class BaseZXJController extends BaseApiController {

    protected String format(String path) {
        return String.format("zxj/%s",  path);
    }
}
