package api.automation;

import com.mycompany.carina.demo.utils.ProductConstants;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.base_url}/products/${id}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.NOT_FOUND_404)
public class GetProductNonExistingId  extends AbstractApiMethodV2 {
		private int id = ProductConstants.TOTAL + 1;
		public GetProductNonExistingId() {
				replaceUrlPlaceholder("id", String.valueOf(id));
		}

		public int getId() {
			return id;
		}
}
