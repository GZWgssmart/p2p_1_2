package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.zzh.bean.Ticket;
import top.zzh.common.Pager;
import top.zzh.enums.ControllerStatusEnum;
import top.zzh.service.TicketService;
import top.zzh.vo.ControllerStatusVO;
import top.zzh.vo.TicketVo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    private Logger logger= LoggerFactory.getLogger(TicketController.class);
    @RequestMapping("pager")
    @ResponseBody
    public Pager pager(int pageIndex, int pageSize,TicketVo ticketVo) {
        return ticketService.listPagerCriteria(pageIndex,pageSize,ticketVo);
    }
    @GetMapping("page")
    public String page(){
        return "/ticket/ticket";
    }
    @PostMapping("getById/{kid}")
    @ResponseBody
    public TicketVo getById(@PathVariable("kid") Long kid){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
        TicketVo ticketvo=(TicketVo) ticketService.getById(kid);
        //ticketvo.setTktime(dateFormat.format(ticketvo.getTktime()));
        return ticketvo;
    }
    @PostMapping("save")
    @ResponseBody
    public ControllerStatusVO save(TicketVo ticketvo){
        ControllerStatusVO statusVO=null;
        if((ticketvo.getTkmoney()==null||ticketvo.getTkmoney().equals(""))&&(ticketvo.getTkmoney4()!=null && !ticketvo.getTkmoney4().equals(""))){
            ticketvo.setTkmoney(ticketvo.getTkmoney4());
        }
        try{
            ticketService.save(ticketvo);
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.TICKET_SAVE_SUCCESS);
        }catch (RuntimeException run){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.TICKET_SAVE_FAIL);
        }
        return statusVO;
    }

    @PostMapping("update")
    @ResponseBody
    public ControllerStatusVO update(TicketVo ticketvo){
        if((ticketvo.getTkmoney()==null||ticketvo.getTkmoney().equals(""))&&(ticketvo.getTkmoney5()!=null && !ticketvo.getTkmoney5().equals(""))){
            ticketvo.setTkmoney(ticketvo.getTkmoney5());
        }
        ControllerStatusVO statusVO=null;
        try{
            ticketService.update(ticketvo);
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.TICKET_UPDATE_SUCCESS);
        }catch (RuntimeException run){
            statusVO = ControllerStatusVO.status(ControllerStatusEnum.TICKET_UPDATE_FAIL);
        }
        return statusVO;
    }
}
