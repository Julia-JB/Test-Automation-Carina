package api.automation;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.base_url}/products/categories", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/categories/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetCategories extends AbstractApiMethodV2 {
	public GetCategories() {}
}
