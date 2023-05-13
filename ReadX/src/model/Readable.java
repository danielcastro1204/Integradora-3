package model;

public interface Readable {

        public final String ADVERTISEMENT_1 = "¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!";
        public final String ADVERTISEMENT_2 = "Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.";
        public final String ADVERTISEMENT_3 = "¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.";
    
        /**
         * Description: This method is responsible for the reading simulation of the bibliographic product according to the action selected by the standard user, in addition to managing the possible advertisements
         * @param action int
         * @return msg String
         */

        public String readBibliographicProductForStandard(int action);

        /**
         * Description: This method is responsible for the reading simulation of the bibliographic product according to the action selected by the premium user
         * @param action int
         * @return msg String
         */

        public String readBibliographicProductForPremium(int action);
}
