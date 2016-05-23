package common;

public class PaymentWeiXin {

    public PaymentWeiXin(Integer paymentID) {
	this.paymentId = paymentID;
	if (paymentID == 2) {// 体育微信公众号配置
	    mchId = "1326087301";
	    appId = "wx5640b8a003a5ee1e";
	    apiKey = "21322c970f32d7c7e327ee55bfa907a3";
	}
    }

    private static Integer paymentId = 1; // 支付类型
    private static String mchId = "1252055901";// 商户号
    private static String appId = "wxfaf1b0d68b17ad91"; // 微信分配的公众号ID（开通公众号之后可以获取到）
    private static String apiKey = "wscd5kgvrvgqd8ifftr3o7p9nkxbi6ka";// api key

    public static void main(String[] args) {
	PaymentWeiXin test = new PaymentWeiXin(2);
	System.out.println(test.mchId);
	System.out.println(test.appId);
	System.out.println(test.apiKey);
	System.out.println(test.paymentId);
    }

}