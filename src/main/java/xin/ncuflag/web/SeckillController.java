package xin.ncuflag.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.ncuflag.Enum.SeckillEnum;
import xin.ncuflag.dto.Exposer;
import xin.ncuflag.dto.SeckillExecution;
import xin.ncuflag.dto.SeckillResult;
import xin.ncuflag.entity.SecKill;
import xin.ncuflag.entity.SuccessKilled;
import xin.ncuflag.exception.SeckillException;
import xin.ncuflag.service.SeckillService;

import java.util.Date;
import java.util.List;

/**
 * Created by vince on 2017/7/22.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getList(Model model){
        List<SecKill> secKills= seckillService.getList();
        model.addAttribute("secKills",secKills);
        return "list";
    }


    @RequestMapping(value="/{seckillId}/detail",method = RequestMethod.GET)
    public String getDetail(@PathVariable("seckillId") Long seckillId,Model model){
        if(seckillId==null){
            return "redirect: ／seckill/list";
        }
       SecKill seckill= seckillService.getById(seckillId);
        if(seckill==null){
            return "forward:/seckill/list";
        }
        model.addAttribute(seckill);
        return "detail";
    }

    @RequestMapping(value="/time/now",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<Long> getNowTime(){
        Long now=new Date().getTime();
        return new SeckillResult<Long>(true,now);
    }

    @RequestMapping(value="/{seckillId}/exposer", method=RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<Exposer> getExposer(@PathVariable("seckillId") Long seckillId){
        if(seckillId==null){
            return new SeckillResult<Exposer>(false, SeckillEnum.NULL_ID);
        }
        Exposer exposer=seckillService.getExposerById(seckillId);
        return new SeckillResult<Exposer>(true,exposer);
    }

    @RequestMapping(value="/{seckillId}/{md5}/execution",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> doSecKill(@PathVariable("seckillId") long seckillId, @PathVariable("md5") String md5, @RequestParam("userPhone") long userPhone){
       try{
        SeckillExecution successKilled=seckillService.executeSeckill(seckillId,userPhone,md5);
           return new SeckillResult<SeckillExecution>(true,successKilled);
       }
        catch(SeckillException e){
            logger.info("SeckillException={}",e.getSeckillEnum().getStateInfo()+e.getSeckillEnum().getCode());
            SeckillExecution successKilled=new SeckillExecution(seckillId,e.getSeckillEnum());
           return new SeckillResult<SeckillExecution>(true,successKilled);
        }
    }
}
