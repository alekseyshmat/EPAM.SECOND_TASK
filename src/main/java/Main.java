import com.epam.parsing.entity.Deposit;
import com.epam.parsing.exception.ParserException;
import com.epam.parsing.parser.JaxbParser;

import java.util.List;

public class Main {
    private static final String PATH = "src/test/resources/deposits.xml";

    public static void main(String[] args) {

        try {
            JaxbParser jaxbParser = new JaxbParser();
            List<Deposit> depositList = jaxbParser.parser(PATH);
            for (Deposit d : depositList) {
                System.out.println(d.getNameOfBank());
                System.out.println(d.getCountry());
                System.out.println(d.getNameOfBank());
                System.out.println(d.getProfitability());
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
