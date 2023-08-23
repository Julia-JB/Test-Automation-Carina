package api.automation;

import com.mycompany.carina.demo.utils.ProductConstants;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.base_url}/products/${id}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetProductByIdMethod extends AbstractApiMethodV2 {
	public GetProductByIdMethod() {
		replaceUrlPlaceholder("id", String.valueOf((int) (Math.random() * ProductConstants.TOTAL) + 1));
	}
}
