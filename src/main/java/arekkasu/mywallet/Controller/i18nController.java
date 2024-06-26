package arekkasu.mywallet.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


/**
 * The type 18 n controller.
 */
@RestController
@RequestMapping("/i18n")
public class i18nController {

    private final MessageSource messageSource;

    /**
     * Instantiates a new 18 n controller.
     *
     * @param messageSource the message source
     */
    public i18nController(@Qualifier("messageSource") MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Gets i 18 n.
     *
     * @param locale the locale
     * @return the i 18 n
     * @throws JsonProcessingException the json processing exception
     */
    @GetMapping
    public String getI18n(Locale locale) throws JsonProcessingException {
        Map<String, String> i18n = getAllMessages(locale);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(i18n);
    }

    private Map<String, String> getAllMessages(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return bundle.keySet().stream()
                .collect(Collectors.toMap(key -> key, key -> messageSource.getMessage(key, null, locale)));
    }




}
