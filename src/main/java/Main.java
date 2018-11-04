import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.TimeDeposit;
import com.epam.parsing.exception.ParserException;
import com.epam.parsing.parser.DepositsDomBuilder;
import com.epam.parsing.parser.DepositsSaxBuilder;
import com.epam.parsing.parser.Jaxb;


public class Main {

    public static void main(String[] args) {
       /* DepositsSaxBuilder depositsSaxBuilder = new DepositsSaxBuilder();
        for (Deposit d : depositsSaxBuilder.parser("src/test/resources/banks.xml")) {
            System.out.println(d.getCountry());
            System.out.println(d.getNameOfBank());
            System.out.println(d.getProfitability());
        }

        DepositsDomBuilder depositsDomBuilder = new DepositsDomBuilder();
        for (Deposit d : depositsDomBuilder.parser("src/test/resources/banks.xml")) {
            System.out.println(d.getCountry());
            System.out.println(d.getNameOfBank());
            System.out.println(d.getProfitability());
            System.out.println(((TimeDeposit)d).getMinimumSum());

        }*/

        Jaxb jaxb = new Jaxb();
        try {
            jaxb.parser("src/test/resources/banks.xml");
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
