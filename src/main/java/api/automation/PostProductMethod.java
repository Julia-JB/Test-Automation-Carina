package api.automation;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.base_url}/products/add", methodType = HttpMethodType.POST)
@Header(key = "Content-Type", value = "application/json")
@RequestTemplatePath(path = "api/products/_post/rq.json")
@ResponseTemplatePath(path = "api/products/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
	public class PostProductMethod extends AbstractApiMethodV2 {
		public PostProductMethod() {}
	}

