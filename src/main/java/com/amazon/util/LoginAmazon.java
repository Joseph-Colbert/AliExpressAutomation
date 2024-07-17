package amazon.util;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.annotation.PageUrl;

@PageUrl(AmazonAbstract.URLAMAZON)
public class LoginAmazon extends FluentPage {
    private static final String SEARCH_FORM_HOMEPAGE = "#search_form_homepage";
}
