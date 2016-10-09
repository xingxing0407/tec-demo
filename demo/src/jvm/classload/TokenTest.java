package jvm.classload;

import org.junit.Test;

import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

public class TokenTest {

	protected static String accessToken = "drG-6OhEqmp7fu1_Eu0g9h-YxWw1ScKLLRQklzk-4WcU5QIAILMXEzABStg0LJH9CN6jWPag3e0a_xTlS_Pr_BmyyJx7TpXN2HmXDBR0U5lsWK89npjxKj5TaGooD7ZXTULgAHAPQH";
	
	@Test
	public void token() {
		Token token = TokenAPI.token("wx26e7cb3a6f4abf72", "4061fce7fd6fab2e19f718d261909cd3");
		accessToken = token.getAccess_token();
		System.out.println(token.getAccess_token());
		// 请复制粘贴access_token 替换accessToken变量的�?，方便其它接口测试类使用
	}
}
