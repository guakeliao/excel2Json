package SERVICE.impl;

import DTO.DataModel;
import SERVICE.DealExcelService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * @author: liaowei
 * @date: 2022/2/18 14:13
 * @description: DealExcelServiceImpl
 */
public class DealExcelServiceImpl implements DealExcelService {
    @Override
    public String readExcel(String filePath) {
        ArrayList<DataModel> arrayList = new ArrayList<>();
        EasyExcel.read(filePath, DataModel.class, new PageReadListener<DataModel>(dataList -> {
            for (DataModel demoData : dataList) {
                arrayList.add(demoData);
            }
        })).sheet().doRead();
        JSONObject ob = new JSONObject();
        //获取required
        ArrayList<String> requireList = new ArrayList<>();
        arrayList.stream().reduce(requireList, (list, item) -> {
            if ("是".equals(item.required)) {
                list.add(item.name);
            }
            return list;
        }, (list, item) -> null);
        ob.put("required", requireList);
        //获取properties
        JSONObject property = new JSONObject();

        arrayList.stream().reduce(property, (pro, item) -> {
            JSONObject sub = new JSONObject();
            sub.put("type", "string");
            sub.put("description", item.description);
            pro.put(item.name, sub);
            return pro;
        }, (pro, item) -> null);
        ob.put("properties", property);
        return ob.toJSONString();
    }
}
