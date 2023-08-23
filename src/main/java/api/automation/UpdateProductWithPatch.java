package api.automation;

import com.mycompany.carina.demo.utils.ProductConstants;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.env.base_url}/products/${id}",
		methodType = HttpMethodType.PATCH)
@Header(key = "Content-Type", value = "application/json")
@RequestTemplatePath(path = "api/products/_patch/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class UpdateProductWithPatch extends AbstractApiMethodV2 {
public UpdateProductWithPatch(){
	replaceUrlPlaceholder("id", String.valueOf((int) (Math.random() * ProductConstants.TOTAL) + 1));
}
}
