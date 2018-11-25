package other;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class SfJsonTest {

    public static void main(String[] args) {
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.009.001.02\">\n" +
                "\t<FinInstnCdtTrf>\n" +
                "\t\t<GrpHdr>\n" +
                "\t\t\t<MsgId>1234567891234567</MsgId>\n" +
                "\t\t\t<CreDtTm>2010-09-15T10:00:00</CreDtTm>\n" +
                "\t\t\t<NbOfTxs>1</NbOfTxs>\n" +
                "\t\t\t<SttlmInf>\n" +
                "\t\t\t\t<SttlmMtd>CLRG</SttlmMtd>\n" +
                "\t\t\t</SttlmInf>\n" +
                "\t\t\t<InstgAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<ClrSysMmbId>\n" +
                "\t\t\t\t\t\t<MmbId>109900000018</MmbId>\n" +
                "\t\t\t\t\t</ClrSysMmbId>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</InstgAgt>\n" +
                "\t\t\t<InstdAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<ClrSysMmbId>\n" +
                "\t\t\t\t\t\t<MmbId>0000</MmbId>\n" +
                "\t\t\t\t\t</ClrSysMmbId>\n" +
                "\t\t\t\t</FinInstnId>\t\t\t\n" +
                "\t\t\t</InstdAgt>\n" +
                "\t\t</GrpHdr>\n" +
                "\t\t<CdtTrfTxInf>\n" +
                "\t\t\t<PmtId>\n" +
                "\t\t\t\t<EndToEndId>1234567891234567</EndToEndId>\n" +
                "\t\t\t\t<TxId>1234567891234567</TxId>\n" +
                "\t\t\t</PmtId>\n" +
                "\t\t\t<PmtTpInf>\n" +
                "\t\t\t\t<SvcLvl>\n" +
                "\t\t\t\t\t<Prtry>G102</Prtry>\n" +
                "\t\t\t\t</SvcLvl>\n" +
                "\t\t\t</PmtTpInf>\n" +
                "\t\t\t<IntrBkSttlmAmt Ccy=\"CNY\">10000000.23</IntrBkSttlmAmt>\n" +
                "\t\t<InstgAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<ClrSysMmbId>\n" +
                "\t\t\t\t\t\t<MmbId>308581000106</MmbId>\n" +
                "\t\t\t\t\t</ClrSysMmbId>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t\t<BrnchId>\n" +
                "\t\t\t\t\t<Id>308581000106</Id>\n" +
                "\t\t\t\t</BrnchId>\n" +
                "\t\t\t</InstgAgt>\n" +
                "\t\t\t<InstdAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<ClrSysMmbId>\n" +
                "\t\t\t\t\t\t<MmbId>104100004370</MmbId>\n" +
                "\t\t\t\t\t</ClrSysMmbId>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t\t<BrnchId>\n" +
                "\t\t\t\t\t<Id>104100004370</Id>\n" +
                "\t\t\t\t</BrnchId>\n" +
                "\t\t\t</InstdAgt>\n" +
                "\t\t\t<Dbtr>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<Nm>林</Nm>\n" +
                "\t\t\t\t\t<PstlAdr>\n" +
                "\t\t\t\t\t\t<AdrLine>地址地址地址</AdrLine>\n" +
                "\t\t\t\t\t</PstlAdr>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</Dbtr>\n" +
                "\t\t\t<DbtrAcct>\n" +
                "\t\t\t\t<Id>\n" +
                "\t\t\t\t\t<Othr>\n" +
                "\t\t\t\t\t\t<Id>2310230111201111210123100010231</Id>\n" +
                "\t\t\t\t\t</Othr>\n" +
                "\t\t\t\t</Id>\n" +
                "\t\t\t</DbtrAcct>\n" +
                "\t\t\t<DbtrAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<ClrSysMmbId>\n" +
                "\t\t\t\t\t\t<MmbId>308581000106</MmbId>\n" +
                "\t\t\t\t\t</ClrSysMmbId>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</DbtrAgt>\n" +
                "\t\t\t<CdtrAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<ClrSysMmbId>\n" +
                "\t\t\t\t\t\t<MmbId>104100004370</MmbId>\n" +
                "\t\t\t\t\t</ClrSysMmbId>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</CdtrAgt>\n" +
                "\t\t\t<Cdtr>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<Nm>肖</Nm>\n" +
                "\t\t\t\t\t<PstlAdr>\n" +
                "\t\t\t\t\t\t<AdrLine>地址地址地址</AdrLine>\n" +
                "\t\t\t\t\t</PstlAdr>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</Cdtr>\n" +
                "\t\t\t<CdtrAcct>\n" +
                "\t\t\t\t<Id>\n" +
                "\t\t\t\t\t<Othr>\n" +
                "\t\t\t\t\t\t<Id>2310230111201111210123100010001</Id>\n" +
                "\t\t\t\t\t</Othr>\n" +
                "\t\t\t\t</Id>\n" +
                "\t\t\t</CdtrAcct>\n" +
                "\t\t\t<RmtInf>\n" +
                "\t\t\t\t<Ustrd>/F25/05023</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/E48/01234567</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/H01/债券市场交易结算</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/E40/12345678909876543210123456789abc</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/D14/CNY100000.23</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/D32/CNY100000.23</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/D33/CNY100000.23</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/D11/CNY100000.23</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/D34/CNY100000.23</Ustrd>\n" +
                "\t\t\t\t<Ustrd>/C19/2010-09-15</Ustrd>\n" +
                "\t\t\t</RmtInf>\n" +
                "\t\t</CdtTrfTxInf>\n" +
                "\t</FinInstnCdtTrf>\n" +
                "</Document>\n";
        XMLSerializer xmlSerializer = new XMLSerializer();
        String resutStr = xmlSerializer.read(xml).toString();
        JSONObject result = JSONObject.fromObject(resutStr);
        System.out.println(result);
    }
}
