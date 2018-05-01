package com.cft.contactmerge.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.cft.contactmerge.*;

class CompareContactPartsTest {
    /****************************************************************************************************************************************************************************
     ********************************************************************* Compare First And Last Name Tests ********************************************************************
     ****************************************************************************************************************************************************************************/
    //---------------------------------------------------------------------------- Basic Names Tests ----------------------------------------------------------------------------
    @Test
    void doNamesMatch_No_DifferentLastName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("John", "Doe", "John", "Adams"));
    }

    @Test
    void doNamesMatch_No_DifferentFirstName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("John", "Doe", "Jane", "Doe"));
    }

    @Test
    void doNamesMatch_Yes_CaseDoesNotMatter() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("john", "DOE", "JOHN", "Doe"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" John", "Doe", "John ", " Doe  "));
    }

    @Test
    void doNamesMatch_Yes_IgnoreSpaces_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" JoHn", "DOE", "JOHN ", " Doe  "));
    }

    //------------------------------------------------------------------------- Punctuation First Names -------------------------------------------------------------------------
    @Test
    void doNamesMatch_Yes_IgnorePunctuationInFirstName() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", "Doe", "An Denise", "Doe"));
    }

    @Test
    void doNamesMatch_Yes_IgnorePunctuationInFirstName_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-denIse", "dOe", "An Denise", "doe"));
    }

    @Test
    void doNamesMatch_Yes_IgnorePunctuationInFirstName_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-denIse ", "Doe ", " An Denise ", "   doe "));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInFirstName() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-De-Denise", "Doe", "An De Denise", "Doe"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInFirstName_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-De-denIse", "dOe", "An dE Denise", "doe"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInFirstName_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-De-denIse ", "dOe ", " An dE Denise ", "   doe "));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstName_DifferentLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("An-De-Denise", "Doe", "An De Denise", "Adams"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstName_CaseInsensitive_DifferentLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("aN-De-denIse", "dOe", "An dE Denise", "adams"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstName_CaseInsensitive_IgnoreSpaces_DifferentLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" aN-De-denIse", " dOe", "   An dE Denise  ", " adams  "));
    }

    //-------------------------------------------------------------------------- Punctuation Last Names -------------------------------------------------------------------------
    @Test
    void doNamesMatch_Yes_IgnorePunctuationInLastName() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Jane", "Doe-Adams", "Jane", "Doe Adams"));
    }

    @Test
    void doNamesMatch_Yes_IgnorePunctuationInLastName_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("jaNe", "Doe-adams", "Jane", "doe Adams"));
    }

    @Test
    void doNamesMatch_Yes_IgnorePunctuationInLastName_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Jane ", "Doe-adams ", "Jane", "  Doe Adams"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInLastName() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "Sa La Democh"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInLastName_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("arEb", "Sa-LA-Democh", "Areb", "sa la democh"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInLastName_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" arEb", " Sa-LA-Democh", "Areb", "sa la democh  "));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInLastName_DifferentFirstNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Hari", "Sa-la-Democh", "Areb", "Sa la Democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInLastName_CaseInsensitive_DifferentFirstNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("haRi", "Sa-LA-Democh", "Areb", "sa la democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInLastName_CaseInsensitive_IgnoreSpaces_DifferentFirstNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" haRi", " Sa-LA-Democh", "Areb", "sa la democh  "));
    }

    //--------------------------------------------------------------------- Punctuation First And Last Names --------------------------------------------------------------------
    @Test
    void doNamesMatch_Yes_IgnorePunctuationInFirstAndLastName() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", "Doe-Adams", "An Denise", "Doe Adams"));
    }

    @Test
    void doNamesMatch_Yes_IgnorePunctuationInFirstAndLastName_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-denIse", "Doe-adams", "An Denise", "Doe Adams"));
    }

    @Test
    void doNamesMatch_Yes_IgnorePunctuationInFirstAndLastName_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-denIse ", "Doe-adams ", " An Denise ", "   Doe Adams"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInFirstAndLastName() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-De-Denise", "Sa-La-Democh", "An De Denise", "Sa La Democh"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-De-denIse", "Sa-LA-Democh", "An dE Denise", "sa la democh"));
    }

    @Test
    void doNamesMatch_Yes_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aN-De-denIse ", " Sa-LA-Democh ", " An dE Denise ", "sa la democh  "));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_DifferentFirstNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("An-Day-Denise", "Sa-la-Democh", "An De Denise", "Sa la Democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive_DifferentFirstNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("aN-Day-denIse", "Sa-LA-Democh", "An dE Denise", "sa la democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive_IgnoreSpaces_DifferentFirstNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" aN-Day-denIse", " Sa-LA-Democh", "   An dE Denise  ", "sa la democh  "));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_DifferentLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("An-De-Denise", "Sa-la-Democh", "An De Denise", "Sa le Democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive_DifferentLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("aN-De-denIse", "Sa-LA-Democh", "An dE Denise", "sa le democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive_IgnoreSpaces_DifferentLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" aN-De-denIse", " Sa-LA-Democh", "   An dE Denise  ", "sa le democh  "));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_DifferentFirstAndLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("An-Day-Denise", "Sa-la-Democh", "An De Denise", "Sa le Democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive_DifferentFirstAndLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("aN-Day-denIse", "Sa-LA-Democh", "An dE Denise", "sa le democh"));
    }

    @Test
    void doNamesMatch_No_IgnoreMultiPunctuationInFirstAndLastName_CaseInsensitive_IgnoreSpaces_DifferentFirstAndLastNames() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" aN-Day-denIse", " Sa-LA-Democh", "   An dE Denise  ", "sa le democh  "));
    }

    //-------------------------------------------------------------------------- Hyphenated First Names -------------------------------------------------------------------------
    // If the name is less than 4 characters and is contained inside the match name, return maybe.
    // If the name is 4 or more characters and is contained inside the match name, return yes.
    @Test
    void doNamesMatch_YesMaybe_HyphenatedFirstNames() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("An-Denise", "Doe", "An", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", "Adams", "Denise", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("An", "Doe", "An-Denise", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Denise", "Adams", "An-Denise", "Adams"));
    }

    @Test
    void doNamesMatch_YesMaybe_HyphenatedFirstNames_CaseInsensitive() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("An-Denise", "Doe", "aN", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", "Adams", "deNise", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("an", "Doe", "An-Denise", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("dEniSe", "Adams", "An-Denise", "Adams"));
    }

    @Test
    void doNamesMatch_YesMaybe_HyphenatedFirstNames_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" An-Denise  ", " Doe", "  aN", "Doe "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", " Adams", "deNise  ", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("an ", "Doe ", "An-Denise ", "Doe   "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" dEniSe", " Adams", " An-Denise", "Adams"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_FirstNamesContainMultiHyphens() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Democh", "Vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Democh", "Mc Vitty", "Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Democh", "Mc", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Democh", "Josephine Mc", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Democh", "Josephine", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Democh", "Josephine Vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Vitty", "Democh", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Mc Vitty", "Democh", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Mc", "Democh", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine Mc", "Democh", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine", "Democh", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine Vitty", "Democh", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Joseph", "Democh", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Democh", "Joseph", "Democh"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_FirstNamesContainMultiHyphens_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-mc-vitty", "Democh", "vittY", "dEmoch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("jOsephine-mc-vitty", "Democh", "mc vitTy", "deMoch"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("joSephine-mc-vitty", "Democh", "mC", "demOch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josEphine-mc-vitty", "Democh", "josephine Mc", "demoCh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josePhine-mc-vitty", "Democh", "josephinE", "democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josepHine-mc-vitty", "DEmoch", "josephiNe vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Vitty", "DEmoch", "josephine-Mc-vitty", "dEmoch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Mc vitty", "DEmoch", "josephinE-mc-vitty", "deMoch"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("mC", "DEmoch", "josephiNe-mc-vitty", "demOch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josephine MC", "DEmoch", "josephIne-mc-vitty", "demoCh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josephinE", "DEmoch", "josepHine-mc-vitty", "democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josephine ViTty", "DEMOCH", "josePhine-mc-vitty", "democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JosePh", "Democh", "JosEphine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JOsephine-Mc-Vitty", "Democh", "joSeph", "Democh"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_FirstNamesContainMultiHyphens_CaseInsensitive_IgnoreSpaces() {
        // if all hyphen names are less than 4, assign maybe return, else return yes
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" Josephine-mc-vitty", "Democh ", "vittY", "dEmoch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("jOsephine-mc-vitty ", " Democh", "mc vitTy", "deMoch"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  joSephine-mc-vitty", "Democh  ", "mC", "demOch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josEphine-mc-vitty  ", "  Democh", "josephine Mc", "demoCh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" josePhine-mc-vitty ", " Democh ", "josephinE", "democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("  josepHine-mc-vitty  ", "  DEmoch  ", "josephiNe vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Vitty", "DEmoch", " josephine-Mc-vitty", " dEmoch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Mc vitty", "DEmoch", "josephinE-mc-vitty ", "deMoch "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("mC", "DEmoch", "  josephiNe-mc-vitty  ", "  demOch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josephine MC", "DEmoch", " josephIne-mc-vitty ", "demoCh  "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josephinE", "DEmoch", "  josepHine-mc-vitty  ", " democH "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" josephine ViTty", " DEMOCH  ", " josePhine-mc-vitty ", " democh "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JosePh", "DemOch", "JosEphine-Mc-Vitty", "DeMoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JOsephine-Mc-Vitty", "DemoCh", "joSeph", "DemocH"));
    }

    @Test
    void doNamesMatch_No_FirstNamesContainMultiHyphens_DifferentLastName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Bedi", "Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Bedi", "Mc Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Bedi", "Mc", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Bedi", "Josephine Mc", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Bedi", "Josephine", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Bedi", "Josephine Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Vitty", "Bedi", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Mc Vitty", "Bedi", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Mc", "Bedi", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine Mc", "Bedi", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine", "Bedi", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine Vitty", "Bedi", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Joseph", "Demo", "Josephine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Demo", "Joseph", "Democh"));
    }

    @Test
    void doNamesMatch_No_FirstNamesContainMultiHyphens_CaseInsensitive_DifferentLastName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-mc-vitty", "Bedi", "vittY", "dEmoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("jOsephine-mc-vitty", "bEdi", "mc vitTy", "deMoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("joSephine-mc-vitty", "beDi", "mC", "demOch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josEphine-mc-vitty", "bedI", "josephine Mc", "demoCh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josePhine-mc-vitty", "BEdi", "josephinE", "democH"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josepHine-mc-vitty", "BeDi", "josephiNe vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Vitty", "BedI", "josephine-Mc-vitty", "dEmoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Mc vitty", "BEDi", "josephinE-mc-vitty", "deMoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("mC", "BEdI", "josephiNe-mc-vitty", "demOch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josephine MC", "BEDI", "josephIne-mc-vitty", "demoCh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josephinE", "BeDI", "josepHine-mc-vitty", "democH"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josephine ViTty", "bedi", "josePhine-mc-vitty", "democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JosePh", "Demo", "JosEphine-Mc-Vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JOsephine-Mc-Vitty", "Demo", "joSeph", "Democh"));
    }

    @Test
    void doNamesMatch_No_FirstNamesContainMultiHyphens_CaseInsensitive_IgnoreSpaces_DifferentLastName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" Josephine-mc-vitty", "Bedi ", "vittY", "dEmoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("jOsephine-mc-vitty ", " bEdi", "mc vitTy", "deMoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  joSephine-mc-vitty", "beDi  ", "mC", "demOch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josEphine-mc-vitty  ", "  bedI", "josephine Mc", "demoCh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" josePhine-mc-vitty ", "  BEdi  ", "josephinE", "democH"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  josepHine-mc-vitty  ", " BeDi ", "josephiNe vitty", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Vitty", "BedI", " josephine-Mc-vitty", "dEmoch "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Mc vitty", "BEDi", "josephinE-mc-vitty ", " deMoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("mC", "BEdI", " josephiNe-mc-vitty ", "demOch  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josephine MC", "BEDI", "  josephIne-mc-vitty  ", "  demoCh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("josephinE ", "BeDI", " josepHine-mc-vitty  ", "  democH  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  josephine ViTty ", "bedi", " josePhine-mc-vitty", " democh "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" JosePh  ", "  Demo ", "JosEphine-Mc-Vitty ", " Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  JOsephine-Mc-Vitty ", " Demo  ", " joSeph", "Democh "));
    }

    //-------------------------------------------------------------------------- Hyphenated Last Names --------------------------------------------------------------------------
    // If the name is less than 4 characters and is contained inside the match name, return maybe.
    // If the name is 4 or more characters and is contained inside the match name, return yes.
    @Test
    void doNamesMatch_YesMaybe_HyphenatedLastNames() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Jane", "Doe-Adams", "Jane", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Jane", "Doe-Adams", "Jane", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Jane", "Doe", "Jane", "Doe-Adams"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Jane", "Adams", "Jane", "Doe-Adams"));
    }

    @Test
    void doNamesMatch_YesMaybe_HyphenatedLastNames_CaseInsensitive() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("jAne", "dOe-adaMs", "janE", "DOE"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("jaNe", "doE-aDams", "jAne", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("janE", "doe", "jaNe", "DOE-adams"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("JANE", "ADAMS", "jane", "DoE-adAmS"));
    }

    @Test
    void doNamesMatch_YesMaybe_HyphenatedLastNames_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("jAne", "dOe-adaMs", "janE", "DOE"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("jaNe", "doE-aDams", "jAne", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("janE", "doe", "jaNe", "DOE-adams"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("JANE", "ADAMS", "jane", "DoE-adAmS"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_LastNamesContainMultiHyphens() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "La Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "La"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "Sa La"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "Sa"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "Sa Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Democh", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "La Democh", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Areb", "La", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa La", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Areb", "Sa", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa Democh", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Areb", "Sa Dem", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Areb", "Sa-La-Democh", "Areb", "Sa Dem"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_LastNamesContainMultiHyphens_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Areb", "Sa-la-democh", "aREB", "democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aReb", "sA-La-democh", "ArEB", "la demoCh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("arEb", "sa-La-democh", "AReB", "lA"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("areB", "sa-lA-democh", "AREb", "sa La"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("AReb", "sa-la-Democh", "aREB", "sA"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("ArEb", "sa-la-dEmoch", "aReB", "Sa democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("AreB", "Democh", "aREb", "sa-la-democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("AReB", "lA democh", "arEb", "sa-la-demoCh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("AREb", "La", "areB", "sa-la-demOch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("ArEB", "Sa la", "aReb", "sa-la-deMoch"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("AREB", "sA", "areb", "sa-lA-democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("areb", "sa dEmoch", "AREB", "Sa-la-democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("arEB", "sa deM", "AReb", "sa-la-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("aREB", "sa-la-demOch", "Areb", "sa dEm"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_LastNamesContainMultiHyphens_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" Areb", "Sa-la-democh ", "aREB ", " democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("aReb ", " sA-La-democh", " ArEB", "la demoCh "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" arEb ", " sa-La-democh ", "  AReB  ", "  lA  "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" areB  ", "  sa-lA-democh ", "  AREb ", " sa La  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  AReb ", " sa-la-Democh  ", " aREB  ", "  sA "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("  ArEb  ", "  sa-la-dEmoch  ", " aReB ", " Sa democh "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("AreB ", " Democh", " aREb", "sa-la-democH "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" AReB", "lA democh ", "arEb ", " sa-la-demoCh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  AREb  ", "  La  ", " areB ", " sa-la-demOch "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("  ArEB ", " Sa la  ", " aReb  ", "  sa-la-deMoch "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" AREB  ", "  sA ", "  areb ", " sa-lA-democh  "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" areb ", " sa dEmoch ", " AREB ", "  Sa-la-democh  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" arEB  ", "  sa deM", " AReb", " sa-la-Democh "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  aREB ", "sa-la-demOch  ", "Areb ", " sa dEm "));
    }

    @Test
    void doNamesMatch_No_LastNamesContainMultiHyphens_DifferentFirstName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-La-Democh", "Areb", "Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-La-Democh", "Areb", "La Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-La-Democh", "Areb", "La"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-La-Democh", "Areb", "Sa La"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-La-Democh", "Areb", "Sa"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-La-Democh", "Areb", "Sa Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Democh", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "La Democh", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "La", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa La", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa Democh", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa Dem", "Areb", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-La-Democh", "Areb", "Sa Dem"));
    }

    @Test
    void doNamesMatch_No_LastNamesContainMultiHyphens_CaseInsensitive_DifferentFirstName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Satya", "Sa-la-democh", "aREB", "democH"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("sAtya", "sA-La-democh", "ArEB", "la demoCh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("saTya", "sa-La-democh", "AReB", "lA"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("satYa", "sa-lA-democh", "AREb", "sa La"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("satyA", "sa-la-Democh", "aREB", "sA"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("SAtya", "sa-la-dEmoch", "aReB", "Sa democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("SaTya", "Democh", "aREb", "sa-la-democH"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("SatYa", "lA democh", "arEb", "sa-la-demoCh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("SatyA", "La", "areB", "sa-la-demOch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("sATya", "Sa la", "aReb", "sa-la-deMoch"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("sAtYa", "sA", "areb", "sa-lA-democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("sAtyA", "sa dEmoch", "AREB", "Sa-la-democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("saTYa", "sa deM", "AReb", "sa-la-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("saTyA", "sa-la-demOch", "Areb", "sa dEm"));
    }

    @Test
    void doNamesMatch_No_LastNamesContainMultiHyphens_CaseInsensitive_IgnoreSpaces_DifferentFirstName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" Satya", "Sa-la-democh ", "aREB ", " democH"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("sAtya ", " sA-La-democh", " ArEB", "la demoCh "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" saTya ", " sa-La-democh ", "  AReB  ", "  lA  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" satYa  ", "  sa-lA-democh ", "  AREb ", " sa La  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  satyA ", " sa-la-Democh  ", " aREB  ", "  sA "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  SAtya  ", "  sa-la-dEmoch  ", " aReB ", " Sa democh "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("SaTya ", " Democh", " aREb", "sa-la-democH "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" SatYa", "lA democh ", "arEb ", " sa-la-demoCh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  SatyA  ", "  La  ", " areB ", " sa-la-demOch "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  sATya ", " Sa la  ", " aReb  ", "  sa-la-deMoch "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" sAtYa  ", "  sA ", "  areb ", " sa-lA-democh  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" sAtyA ", " sa dEmoch ", " AREB ", "  Sa-la-democh  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" saTYa  ", "  sa deM", " AReb", " sa-la-Democh "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  saTyA ", "sa-la-demOch  ", "Areb ", " sa dEm "));
    }

    //--------------------------------------------------------------------- Hyphenated First and Last Names ---------------------------------------------------------------------
    // If the name is less than 4 characters and is contained inside the match name, return maybe.
    // If the name is 4 or more characters and is contained inside the match name, return yes.

    @Test
    void doNamesMatch_YesMaybe_HyphenatedFirstAndLastNames() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("An-Denise", "Doe", "An", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", "Adams", "Denise", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("An", "Doe", "An-Denise", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Denise", "Adams", "An-Denise", "Adams"));
    }

    @Test
    void doNamesMatch_YesMaybe_HyphenatedFirstAndLastNames_CaseInsensitive() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("An-Denise", "Doe", "aN", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", "Adams", "deNise", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("an", "Doe", "An-Denise", "Doe"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("dEniSe", "Adams", "An-Denise", "Adams"));
    }

    @Test
    void doNamesMatch_YesMaybe_HyphenatedFirstAndLastNames_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" An-Denise  ", " Doe", "  aN", "Doe "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("An-Denise", " Adams", "deNise  ", "Adams"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("an ", "Doe ", "An-Denise ", "Doe   "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" dEniSe", " Adams", " An-Denise", "Adams"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_FirstAndLastNamesContainMultiHyphens() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Sa-La-Democh", "Vitty", "Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Sa-La-Democh", "Mc Vitty", "La Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Sa-La-Democh", "Mc", "La"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Sa-La-Democh", "Josephine Mc", "Sa La"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Sa-La-Democh", "Josephine", "Sa"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Sa-La-Democh", "Josephine Vitty", "Sa Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Vitty", "Democh", "Josephine-Mc-Vitty", "Sa-La-Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Mc Vitty", "La Democh", "Josephine-Mc-Vitty", "Sa-La-Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Mc", "La", "Josephine-Mc-Vitty", "Sa-La-Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine Mc", "Sa La", "Josephine-Mc-Vitty", "Sa-La-Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Josephine", "Sa", "Josephine-Mc-Vitty", "Sa-La-Democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine Vitty", "Sa Democh", "Josephine-Mc-Vitty", "Sa-La-Democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Joseph", "Lee", "Josephine-Mc-Vitty", "Sa-La-Cathleen"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("Josephine-Mc-Vitty", "Sa-La-Cathleen", "Joseph", "La Lee"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_FirstAndLastNamesContainMultiHyphens_CaseInsensitive() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Josephine-mc-vitty", "Sa-la-democh", "vittY", "democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("jOsephine-mc-vitty", "sA-La-democh", "mc vitTy", "la demoCh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("joSephine-mc-vitty", "sa-La-democh", "mC", "lA"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josEphine-mc-vitty", "sa-lA-democh", "josephine Mc", "sa La"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("josePhine-mc-vitty", "sa-la-Democh", "josephinE", "sA"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josepHine-mc-vitty", "sa-la-dEmoch", "josephiNe vitty", "Sa democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Vitty", "Democh", "josephine-Mc-vitty", "sa-la-democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Mc vitty", "LA democh", "josephinE-mc-vitty", "sa-la-demoCh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("mC", "La", "josephiNe-mc-vitty", "sa-la-demOch"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josephine MC", "Sa la", "josephIne-mc-vitty", "sa-la-deMoch"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("josephinE", "sA", "josepHine-mc-vitty", "sa-LA-democh"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("josephine viTty", "sa dEmoch", "josePhine-mc-vitty", "Sa-la-democh"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JosePh", "leE", "JosEphine-Mc-Vitty", "sa-la-Cathleen"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("JOsephine-Mc-Vitty", "sa-la-cathLeen", "joSeph", "la lEe"));
    }

    @Test
    void doNamesMatch_YesMaybeNo_FirstAndLastNamesContainMultiHyphens_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" Josephine-mc-vitty", "Sa-la-democh ", "vittY ", " democH"));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("jOsephine-mc-vitty ", " sA-La-democh", " mc vitTy", "la demoCh "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" joSephine-mc-vitty ", " sa-La-democh ", "  mC  ", "  lA  "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" josEphine-mc-vitty  ", "  sa-lA-democh ", "  josephine Mc ", " sa La  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  josePhine-mc-vitty ", " sa-la-Democh  ", " josephinE  ", "  sA "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("  josepHine-mc-vitty  ", "  sa-la-dEmoch  ", " josephiNe vitty ", " Sa democh "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("Vitty ", " Democh", " josephine-Mc-vitty", "sa-la-democH "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" Mc vitty", "LA democh ", "josephinE-mc-vitty ", " sa-la-demoCh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  mC  ", "  La  ", " josephiNe-mc-vitty ", " sa-la-demOch "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch("  josephine MC ", " Sa la  ", " josephIne-mc-vitty  ", "  sa-la-deMoch "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" josephinE  ", "  sA ", "  josepHine-mc-vitty ", " sa-LA-democh  "));
        assertEquals(AnswerType.yes, CompareContactParts.doNamesMatch(" josephine viTty ", " sa dEmoch ", " josePhine-mc-vitty ", "  Sa-la-democh  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" JosePh  ", "  leE", " JosEphine-Mc-Vitty", " sa-la-Cathleen "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  JOsephine-Mc-Vitty ", "sa-la-cathLeen  ", "joSeph ", " la lEe "));
    }

    //----------------------------------------------------------------------- Last and First Names Swapped ----------------------------------------------------------------------
    @Test
    void doNamesMatch_Maybe_FirstLastSwap() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("John", "Doe", "Doe", "John"));
    }

    @Test
    void doNamesMatch_Maybe_FirstLastSwap_CaseInsensitive() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("joHn", "Doe", "doe", "JOhn"));
    }

    @Test
    void doNamesMatch_Maybe_FirstLastSwap_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" joHn  ", "  Doe ", " doe", "JOhn "));
    }

    @Test
    void doNamesMatch_Maybe_FirstLastSwap_CaseInsensitive_IgnoreSpaces_Punctuation() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" aN-Day-denIse  ", "  Sa-LA-Democh ", " sa le democh", "An dE Denise "));
    }

    @Test
    void doNamesMatch_Maybe_FirstLastSwap_CaseInsensitive_IgnoreSpaces_Hyphenated() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" Josephine-mc-vitty", "Sa-la-democh ", "democH ", " vittY"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("jOsephine-mc-vitty ", " sA-La-democh", " la demoCh", "mc vitTy "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" joSephine-mc-vitty ", " sa-La-democh ", "  lA  ", "  mC  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" josEphine-mc-vitty  ", "  sa-lA-democh ", "  sa La ", " josephine Mc  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  josePhine-mc-vitty ", " sa-la-Democh  ", " sA  ", "  josephinE "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  josepHine-mc-vitty  ", "  sa-la-dEmoch  ", " Sa democh ", " josephiNe vitty "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Vitty ", " Democh", " sa-la-democH", "josephine-Mc-vitty "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" Mc vitty", "LA democh ", "sa-la-demoCh ", " josephinE-mc-vitty"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  mC  ", "  La  ", " sa-la-demOch ", " josephiNe-mc-vitty "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  josephine MC ", " Sa la  ", " sa-la-deMoch  ", "  josephIne-mc-vitty "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" josephinE  ", "  sA ", "  sa-LA-democh ", " josepHine-mc-vitty  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" josephine viTty ", " sa dEmoch ", " Sa-la-democh ", "  josePhine-mc-vitty  "));
    }

    //--------------------------------------------------------------------------- First Name Initials ---------------------------------------------------------------------------
    // Rule: program will not allow last name initials
    // Only matches with a maybe if it is first name
    @Test
    void doNamesMatch_Maybe_FirstNameInitials() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("John", "Doe", "J", "Doe"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("J.", "Doe", "John", "Doe"));
    }

    @Test
    void doNamesMatch_Maybe_FirstNameInitials_CaseInsensitive() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("John", "Doe", "j", "dOe"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("J.", "Doe", "joHn", "doe"));
    }

    @Test
    void doNamesMatch_Maybe_FirstNameInitials_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" John  ", "  Doe ", "j ", " dOe"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("J. ", " Doe", "  joHn ", " doe  "));
    }

    @Test
    void doNamesMatch_Maybe_FirstNameInitials_CaseInsensitive_IgnoreSpaces_Punctuation() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" JosepHine-mc-vitty  ", "  Doe ", "j ", " dOe"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("J. ", " Doe", "  josepHine Mc Vitty ", " doe  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" JosepHine-mc-vitty  ", "  sa-la-dEmoch ", "j ", " sa la Democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("J. ", " sa La democh", "  josepHine Mc Vitty ", " Sa-la-democh  "));
    }

    @Test
    void doNamesMatch_Maybe_FirstNameInitials_CaseInsensitive_IgnoreSpaces_Hyphenated() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" JosepHine-mc-vitty  ", "  Doe ", "j ", " dOe"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("J. ", " Doe", "  josepHine Vitty ", " doe  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" JosepHine-mc-vitty  ", "  sa-la-dEmoch ", "j ", " Sa democh"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("J. ", " Sa democh", "  josepHine Vitty ", " sa-la-dEmoch  "));
    }

    @Test
    void doNamesMatch_No_FirstNameInitialsDifferentLastName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("John", "Adams", "J", "Doe"));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("J.", "Doe", "John", "Adams"));
    }

    //------------------------------------------------------------------------------- Other Tests -------------------------------------------------------------------------------
    @Test
    void doNamesMatch_Maybe_Apostrophe() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Adrianno", "D'onofio", "Adrianno", "D onofio"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("Adrianno", "Donofio", "Adrianno", "D'onofio"));
    }

    @Test
    void doNamesMatch_Maybe_Apostrophe_CaseInsensitive() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("adriaNno", "d'onOfio", "adrianNo", "d onofiO"));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("adrianno", "doNofio", "Adrianno", "d'onoFio"));
    }

    @Test
    void doNamesMatch_Maybe_Apostrophe_CaseInsensitive_IgnoreSpaces() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  josepHine-mc-vitty ", "d'onOfio ", " josephiNe mc vItty", " d onofiO  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" josepHine mc vitty  ", " doNofio", "Josephine-mc-vitty ", "  d'onoFio "));
    }

    @Test
    void doNamesMatch_Maybe_Apostrophe_CaseInsensitive_IgnoreSpaces_Punctuation() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  josepHine-mc-vitty ", "d'onOfio ", " josephiNe mc vItty", " d onofiO  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" josepHine mc vitty  ", " doNofio", "Josephine-mc-vitty ", "  d'onoFio "));
    }

    @Test
    void doNamesMatch_Maybe_Apostrophe_CaseInsensitive_IgnoreSpaces_Hyphenated() {
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch("  josepHine-mc-vitty ", "d'onOfio ", " josephiNe vItty", " d onofiO  "));
        assertEquals(AnswerType.maybe, CompareContactParts.doNamesMatch(" mc vitty  ", " doNofio", "Josephine-mc-vitty ", "  d'onoFio "));
    }

    @Test
    void doNamesMatch_No_Apostrophe_CaseInsensitive_IgnoreSpaces_DifferentFirstName() {
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch("  josepHine-mc-vitty ", "d'onOfio ", " josepH", " d onofiO  "));
        assertEquals(AnswerType.no, CompareContactParts.doNamesMatch(" joSeph  ", " doNofio", "Josephine-mc-vitty ", "  d'onoFio "));
    }

    // TODO: Add other name tests
    // 1. Middle initials, Prefix, and Suffix
    // 2. Common forms like: Robert, Robbie, Bob
    // 3. Compare household name to individual name
    // 4. Handle mispellings(??)

    /*************************
     * Compare Address Tests *
     *************************/

    @Test
    void doAddressesMatch_Yes_IgnoreCase() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 main Street", "123 Main street"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfStreet() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Street", "123 Main St"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfAvenue() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Avenue", "123 Main Ave"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfDrive() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Dr", "123 Main Drive"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfLane() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Lane", "123 Main Ln"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfTrail() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Trail", "123 Main trl."));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfCircle() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Circle", "123 Main Cir"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfBoulevard() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Blvd", "123 Main Boulevard"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfRoad() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main Road", "123 Main Rd"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfPOBox() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("P.O. Box 1234", "PO Box 1234"));
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("P O Box 1234", "PO Box 1234"));
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("PO Box 1234", "Box 1234"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfNorth() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 North Main St", "123 N Main St"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfSouth() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 S Main St", "123 South Main St"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfEast() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 East Main St", "123 E Main St"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfWest() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 West Main St", "123 W Main St"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfApartment() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main St, Apt 40", "123 Main St, Apartment 40"));
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main St, Apt 40", "123 Main St, 40"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfSuite() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main St, Suite 40", "123 Main St, Ste 40"));
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main St, Suite 40", "123 Main St, 40"));
    }

    @Test
    void doAddressesMatch_Yes_FormsOfUnit() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main St, Unit 40", "123 Main St, 40"));
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("123 Main St, #40", "123 Main St, 40"));
    }

    @Test
    void doAddressesMatch_Yes_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doAddressesMatch("  123 Main St", "123  Main St  "));
    }

    @Test
    void doAddressesMatch_Maybe_MissingApartment() {
        assertEquals(AnswerType.maybe, CompareContactParts.doAddressesMatch("123 Main St, Apt 40", "123 Main St"));
    }

    @Test
    void doAddressesMatch_Maybe_MissingRoadType() {
        assertEquals(AnswerType.maybe, CompareContactParts.doAddressesMatch("123 Main", "123 Main St"));
    }

    @Test
    void doAddressesMatch_No_DifferentAddress() {
        assertEquals(AnswerType.no, CompareContactParts.doAddressesMatch("123 Main St", "1234 Main St"));
    }

    @Test
    void doAddressesMatch_No_DifferentApartment() {
        assertEquals(AnswerType.no, CompareContactParts.doAddressesMatch("123 Main St, Unit 10", "123 Main St, Unit 11"));
    }

    @Test
    void doCitiesMatch_Yes_IgnoreCase() {
        assertEquals(AnswerType.yes, CompareContactParts.doCitiesMatch("Tucson", "TUCSON"));
    }

    @Test
    void doCitiesMatch_Yes_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doCitiesMatch("Tucson  ", "Tucson"));
    }

    @Test
    void doCitiesMatch_No() {
        assertEquals(AnswerType.no, CompareContactParts.doCitiesMatch("Tucson", "Phoenix"));
    }

    @Test
    void doStatesMatch_Yes_IgnoreCase() {
        assertEquals(AnswerType.yes, CompareContactParts.doStatesMatch("AZ", "az"));
    }

    @Test
    void doStatesMatch_Yes_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doStatesMatch("AZ", " AZ    "));
    }

    @Test
    void doStatesMatch_Yes_Abbreviations() {
        assertEquals(AnswerType.yes, CompareContactParts.doStatesMatch("AZ", "Arizona"));
        assertEquals(AnswerType.yes, CompareContactParts.doStatesMatch("California", "CA"));
        assertEquals(AnswerType.yes, CompareContactParts.doStatesMatch("New York", "NY"));
    }

    @Test
    void doStatesMatch_No() {
        assertEquals(AnswerType.no, CompareContactParts.doStatesMatch("New York", "Arizona"));
    }

    @Test
    void doPhoneNumbersMatch_Yes_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doPhoneNumbersMatch("520 123 4567", "5201234567"));
    }

    @Test
    void doPhoneNumbersMatch_Yes_IgnorePunctuation() {
        assertEquals(AnswerType.yes, CompareContactParts.doPhoneNumbersMatch("(520) 123-4567", "5201234567"));
        assertEquals(AnswerType.yes, CompareContactParts.doPhoneNumbersMatch("(520) 123-4567", "520-123-4567"));
    }

    @Test
    void doPhoneNumbersMatch_No() {
        assertEquals(AnswerType.no, CompareContactParts.doPhoneNumbersMatch("(520) 123-4567", "(520) 123-4667"));
    }

    @Test
    void doEmailsMatch_Yes_IgnoreSpaces() {
        assertEquals(AnswerType.yes, CompareContactParts.doEmailsMatch("jdoe@yahoo.com", " jdoe@yahoo.com "));
    }

    @Test
    void doEmailsMatch_Yes_IgnoreCase() {
        assertEquals(AnswerType.yes, CompareContactParts.doEmailsMatch("jdoe@yahoo.com", "JDoe@Yahoo.com"));
    }

    @Test
    void doEmailsMatch_No() {
        assertEquals(AnswerType.no, CompareContactParts.doEmailsMatch("jdoe@yahoo.com", "jdoe@gmail.com"));
    }
}