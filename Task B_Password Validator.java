@Controller
@RequestMapping("/registration")
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new CharacterRule(EnglishCharacterData, 1), // one alphabet
                new CharacterRule(EnglishCharacterData.Digit, 1), //one digit
                new CharacterRule(EnglishCharacterData.Special, 1),  // one special character
        ));
        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid())  { 
           log.info("Registration Successful!!");
            return "registration"
        }
        else{
          return "Password must contain atleast 1 alphabet, 1 number & 1 special character"       
           return "registration";
           
     /* use ContraintvalidatorContext to display the error in the typed passowrd
     List<String> messages = validator.getMessages(result);
        String messageTemplate = messages.stream().collect(Collectors.joining(","));
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
     log.debug(messages); */

    }
}
