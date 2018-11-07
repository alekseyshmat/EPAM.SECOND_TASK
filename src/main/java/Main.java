import com.epam.parsing.entity.Deposit;
import com.epam.parsing.exception.ParserException;
import com.epam.parsing.factory.CreateXmlParser;
import com.epam.parsing.parser.JaxbParser;
import com.epam.parsing.parser.SaxParser;

import java.util.List;

public class Main {
    private static final String PATH = "src/test/resources/deposits.xml";

    public static void main(String[] args) {

        /*CreateXmlParser createXmlParser = new CreateXmlParser();
        createXmlParser.createDeposits("SAXPARSER");

        SaxParser depositsSaxBuilder = new SaxParser();
        for (Deposit d : depositsSaxBuilder.parser("src/test/resources/banks.xml")) {
            System.out.println(d.getCountry());
            System.out.println(d.getNameOfBank());
            System.out.println(d.getProfitability());
        }*/
/*
        DomParser depositsDomBuilder = new DomParser();
        for (Deposit d : depositsDomBuilder.parser("src/test/resources/banks.xml")) {
            System.out.println(d.getCountry());
            System.out.println(d.getNameOfBank());
            System.out.println(d.getProfitability());
            System.out.println(((TimeDeposit)d).getMinimumSum());

        }*/

        try {
            JaxbParser jaxbParser = new JaxbParser();
            List<Deposit> depositList = jaxbParser.parser(PATH);
            for (Deposit d : depositList) {
                System.out.println(d.getCountry());
                System.out.println(d.getNameOfBank());
                System.out.println(d.getProfitability());
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
