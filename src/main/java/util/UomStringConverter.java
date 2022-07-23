package util;///*******************************************************************************
// * Copyright(c) 2015-2020 Incheon International Airport Corporation.
// * All rights reserved. This software is the proprietary information of
// * Incheon International Airport Corporation.
// *******************************************************************************/
//
//package util;
//
//import javafx.util.StringConverter;
//
///**
// * UomStringConverter
// *
// * @author <a href="mailto:mhjang@nextree.co.kr">Jang, Mihyeon</a>
// * @since 2018. 12. 04.
// */
//
//public class UomStringConverter extends StringConverter<Double> {
//    //
//    private UOM uom;
//
//    public UomStringConverter(UOM uom) {
//        //
//        this.uom = uom;
//    }
//
//    @Override
//    public String toString(Double object) {
//        if (object == null || uom == null) {
//            return null;
//        }
//
//        String unitString = "cm";
//        switch (uom) {
//            case CentiMeter: unitString = "cm"; break;
//            case Ton: unitString = "t"; break;
//            case Meter: unitString = "m"; break;
//            case KiloGram: unitString = "kg"; break;
//            case KiloMeter: unitString = "km"; break;
//            case MilliMeter: unitString = "mm"; break;
//        }
//
//        return String.format("%s %s", String.valueOf(object), unitString);
//    }
//
//    @Override
//    public Double fromString(String string) {
//        String[] strings = string.split(uom.name());
//        return Double.parseDouble(strings[0].trim());
//    }
//}