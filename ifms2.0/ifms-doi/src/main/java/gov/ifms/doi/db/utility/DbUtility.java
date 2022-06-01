package gov.ifms.doi.db.utility;

import gov.ifms.doi.jpa.dto.DoiCommonLookUpInfoDTO;
import gov.ifms.doi.jpa.service.imp.DoiCommonLookupInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class DbUtility {

    @Autowired
    DoiCommonLookupInfoServiceImpl doiCommonLookupInfoServiceImpl;

    public String getReferenceNumber(String referenceNumberKey,String referencePath) {
        List<DoiCommonLookUpInfoDTO> response = doiCommonLookupInfoServiceImpl
                .getByParentLookUpName(referenceNumberKey);
        String formatted = String.valueOf(Long.parseLong(response.get(0).getLookupInfoValue()) + 1);
        doiCommonLookupInfoServiceImpl.updateLookupInfoValue(referenceNumberKey, formatted);
        int lastTwoDigits = Calendar.getInstance().get(Calendar.YEAR) % 100;
        return lastTwoDigits + "-" + (lastTwoDigits + 1) + referencePath + formatted;
    }
}
