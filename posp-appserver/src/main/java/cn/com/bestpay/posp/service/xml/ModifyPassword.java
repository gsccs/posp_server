package cn.com.bestpay.posp.service.xml;

import org.dom4j.Element;
import org.springframework.stereotype.Component;

import cn.com.bestpay.posp.system.entity.XmlMessage;
@Component("1004")
public class ModifyPassword extends BaseService{

	@Override
	public byte[] setMessage(XmlMessage xmlMessage) {
		return super.setMessage(xmlMessage);
	}
	@Override
	public void setBody(Element root,XmlMessage xmlMessage) {

	}

}
