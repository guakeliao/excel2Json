import SERVICE.DealExcelService;
import SERVICE.impl.DealExcelServiceImpl;

/**
 * @author: liaowei
 * @date: 2022/2/18 14:29
 * @description: test
 */
public class test {

    public static void main(String[] args) {
        DealExcelServiceImpl dealExcel = new DealExcelServiceImpl();
        String json = dealExcel.readExcel("/Users/liaowei/Desktop/test.xlsx");
        System.out.println(json);
    }
}
