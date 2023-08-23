package api.automation;

import com.mycompany.carina.demo.utils.ProductConstants;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.env.base_url}/products/${id}", methodType = HttpMethodType.DELETE)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteProduct extends AbstractApiMethodV2 {
	public DeleteProduct() {
		replaceUrlPlaceholder("id", String.valueOf((int) (Math.random() * ProductConstants.TOTAL) + 1));
	}
}
