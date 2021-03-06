package cc.ryanc.halo.web.controller.api;

import cc.ryanc.halo.model.domain.Link;
import cc.ryanc.halo.model.dto.JsonResult;
import cc.ryanc.halo.model.enums.ResponseStatus;
import cc.ryanc.halo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : RYAN0UP
 * @date : 2018/6/6
 */
@RestController
@RequestMapping(value = "/api/links")
public class ApiLinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 获取所有友情链接
     *
     * @return JsonResult
     */
    @GetMapping
    public JsonResult links(){
        List<Link> links = linkService.findAllLinks();
        if(null!=links && links.size()>0){
            return new JsonResult(ResponseStatus.SUCCESS.getCode(),ResponseStatus.SUCCESS.getMsg(),links);
        }else{
            return new JsonResult(ResponseStatus.EMPTY.getCode(),ResponseStatus.EMPTY.getMsg());
        }
    }
}
