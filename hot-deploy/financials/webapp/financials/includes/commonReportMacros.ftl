<#--
 * Copyright (c) 2009 - 2009 Open Source Strategies, Inc.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the Honest Public License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Honest Public License for more details.
 *
 * You should have received a copy of the Honest Public License
 * along with this program; if not, write to Funambol,
 * 643 Bair Island Road, Suite 305 - Redwood City, CA 94063, USA
-->

<@import location="component://opentaps-common/webapp/common/includes/lib/opentapsFormMacros.ftl"/>

<#-- 
Defines macros shared by the financials reports.

To use these macros in your page, first put this at the top:

<@import location="component://financials/webapp/financials/includes/commonReportMacros.ftl"/>
-->

<#-- a function to "disable" the other date option when one is selected -->
<#macro commonReportJs formName>
<script type="text/javascript">
/*<![CDATA[*/
  function selectReportDateOption(button) {
    var form = button.form;
    var dateFields = ['fromDate', 'fromDate1', 'fromDate2',
                      'thruDate', 'thruDate1', 'thruDate2',
                      'asOfDate'];
    var periodFields = ['customTimePeriodId', 'fromCustomTimePeriodId', 'thruCustomTimePeriodId'];
    if (button.checked == true) {
      var setDateFieldsDisabled = false;
      if (button.value == "byDate") {
        setDateFieldsDisabled = false;
      } else if (button.value == "byTimePeriod") {
        setDateFieldsDisabled = true;
      }

      for (var i=0; i<dateFields.length; i++) {
        var input = form[dateFields[i]];
        if (input) {
            input.disabled = setDateFieldsDisabled;
        }
      }

      for (var i=0; i<periodFields.length; i++) {
        var input = form[periodFields[i]];
        if (input) {
            input.disabled = !setDateFieldsDisabled;
        }
      }
    }
  }

  function doSubmit(action, target) {
    document.${formName}.type.value = target;
    document.${formName}.reportAction.value = '';
    document.${formName}.action = action;
    document.${formName}.submit();
  }
/*]]>*/
</script>
</#macro>

<#macro listCustomTimePeriods customTimePeriods defaultTimePeriodId="">
  <#list customTimePeriods as customTimePeriod>
    <#assign selected=""/>
    <#if defaultTimePeriodId == customTimePeriod.customTimePeriodId><#assign selected="selected"></#if>
    <option ${selected!} value="${customTimePeriod.customTimePeriodId}">${customTimePeriod.periodName!} 
      <#if customTimePeriod.periodNum?has_content>
        ${customTimePeriod.periodNum?string("####")}
      </#if> 
      <#if customTimePeriod.fromDate?has_content>${uiLabelMap.FinancialsBeginningOn} ${getLocalizedDate(customTimePeriod.fromDate, "DATE_ONLY")}</#if>
      <#if customTimePeriod.thruDate?has_content>${uiLabelMap.FinancialsEndingOn} ${getLocalizedDate(customTimePeriod.thruDate, "DATE_ONLY")}</#if>
      <#if customTimePeriod.isClosed == "Y">
        (${uiLabelMap.FinancialsTimePeriodIsClosed})
      <#else>
        (${uiLabelMap.FinancialsTimePeriodIsNotClosed})
      </#if>
    </option>
  </#list>
</#macro>

<#-- common party input -->
<#macro partyInput label form default="">
  <div style="margin: 5px 30px 5px;">
    <span class="tableheadtext">${uiLabelMap.get(label)}</span>
    <@inputAutoCompleteParty name="partyId" default=default form=form />
  </div>
</#macro>

<#-- common product input -->
<#macro productInput form default="">
  <div style="margin: 5px 30px 5px;">
    <span class="tableheadtext">${uiLabelMap.ProductProductId}</span>
    <@inputAutoCompleteProduct name="productId" default=default form=form />
  </div>
</#macro>

<#-- A date input -->
<#macro asOfDateInputRow defaultAsOfDate="" byDateChecked="" withRadioButton=true>
  <table>
    <tr>
      <#if withRadioButton><td><input type="radio" name="reportDateOption" value="byDate" onClick="javascript:selectReportDateOption(this)" ${byDateChecked}></input></td></#if>
      <td class="tableheadtext">${uiLabelMap.OpentapsAsOfDate}</td>
      <td>
        <#if requestParameters.asOfDate?exists>
          <#assign date = requestParameters.asOfDate />
        <#else>
          <#assign date = defaultAsOfDate />
        </#if>
        <@inputDate name="asOfDate" default=getDefaultValue("asOfDate", defaultAsOfDate)/><@displayError name="asOfDate" />
      </td>
    </tr>
  </table>
</#macro>

<#macro compareDateInputRow defaultFromDate="" defaultThruDate="" byDateChecked="">
  <table>
    <tr>
      <td><input type="radio" name="reportDateOption" value="byDate" onClick="javascript:selectReportDateOption(this)" ${byDateChecked}></input></td>
      <td class="tableheadtext">${uiLabelMap.FinancialsCompareDate}</td>
      <td><@inputDate name="fromDate" default=getDefaultValue("fromDate", defaultFromDate)/><@displayError name="fromDate" /></td>
      <td class="tableheadtext">${uiLabelMap.FinancialsCompareDateTo}</td>
      <td><@inputDate name="thruDate" default=getDefaultValue("thruDate", defaultThruDate)/><@displayError name="thruDate" /></td>
    </tr>
  </table>
</#macro>

<#macro dateRangeInputRow defaultFromDate="" defaultThruDate="" byDateChecked="" >
  <table>
    <tr>
      <td><input type="radio" name="reportDateOption" value="byDate" onClick="javascript:selectReportDateOption(this)" ${byDateChecked}/></td>
      <td class="tableheadtext">${uiLabelMap.CommonFromDate}</td>
      <td><@inputDate name="fromDate" default=getDefaultValue("fromDate", defaultFromDate)/><@displayError name="fromDate" /></td>
      <td class="tableheadtext">${uiLabelMap.CommonThruDate}</td>
      <td><@inputDate name="thruDate" default=getDefaultValue("thruDate", defaultThruDate)/><@displayError name="thruDate" /></td>
    </tr>
  </table>
</#macro>

<#macro compareDateRangeInputRow byDateChecked="" defaultFromDate1="" defaultThruDate1="" defaultFromDate2="" defaultThruDate2="">
  <table>
    <tr>
      <td><input type="radio" name="reportDateOption" value="byDate" onClick="javascript:selectReportDateOption(this)" ${byDateChecked}></input></td>
      <td class="tableheadtext">${uiLabelMap.FinancialsCompareDates}:</td>
      <td class="tabletext">
        ${uiLabelMap.CommonFrom}
        <@inputDate name="fromDate1" default=getDefaultValue("fromDate1", defaultFromDate1)/><@displayError name="fromDate2" />
      </td>
      <td class="tabletext">
        ${uiLabelMap.CommonThru}
        <@inputDate name="thruDate1" default=getDefaultValue("thruDate1", defaultThruDate1)/><@displayError name="thruDate1" />
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td class="tableheadtext">${uiLabelMap.FinancialsCompareDatesTo}:</td>
      <td class="tabletext">
        ${uiLabelMap.CommonFrom}
        <@inputDate name="fromDate2" default=getDefaultValue("fromDate2", defaultFromDate2)/><@displayError name="fromDate2" />
      </td>
      <td class="tabletext">
        ${uiLabelMap.CommonThru}
        <@inputDate name="thruDate2" default=getDefaultValue("thruDate2", defaultThruDate2)/><@displayError name="thruDate2" />
      </td>
    </tr>
  </table>
</#macro>

<#macro dateTimeRangeInputRows defaultFromDate="" defaultThruDate="">
  <div style="margin: 5px 30px 5px;">
    <span class="tableheadtext">${uiLabelMap.CommonFromDate}</span>
    <@inputDateTime name="fromDate" default=getDefaultValue("fromDate", defaultFromDate)/><@displayError name="fromDate" />
  </div>
  <div style="margin: 5px 30px 5px;">
    <span class="tableheadtext">${uiLabelMap.CommonThruDate}</span>
    <@inputDateTime name="thruDate" default=getDefaultValue("thruDate", defaultThruDate)/><@displayError name="thruDate" />
  </div>
</#macro>

<#-- A drop down of Time Periods -->
<#macro timePeriodInput name customTimePeriods defaultTimePeriodId="">
  <select class="selectBox" name="${name}" size="1">
    <@listCustomTimePeriods customTimePeriods=customTimePeriods defaultTimePeriodId=getDefaultValue(name, defaultTimePeriodId)/>
  </select>
</#macro>

<#macro timePeriodInputRow customTimePeriods defaultTimePeriodId="" byTimePeriodChecked="">
  <table>
    <tr>
      <td><input type="radio" name="reportDateOption" value="byTimePeriod" onClick="javascript:selectReportDateOption(this)" ${byTimePeriodChecked}></input></td>
      <td class="tableheadtext">${uiLabelMap.AccountingTimePeriod}</td>
      <td><@timePeriodInput name="customTimePeriodId" customTimePeriods=customTimePeriods defaultTimePeriodId=defaultTimePeriodId/></td>
    </tr>
  </table>
</#macro>

<#macro compareTimePeriodInputRow customTimePeriods defaultFrom="" defaultThru="" byTimePeriodChecked="">
  <table>
    <tr>
      <td><input type="radio" name="reportDateOption" value="byTimePeriod" onClick="javascript:selectReportDateOption(this)" ${byTimePeriodChecked}></input></td>
      <td class="tableheadtext">${uiLabelMap.FinancialsCompareTimePeriod}</td>
      <td><@timePeriodInput name="fromCustomTimePeriodId" customTimePeriods=customTimePeriods defaultTimePeriodId=defaultFrom/></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td class="tableheadtext">${uiLabelMap.FinancialsCompareTimePeriodTo}</td>
      <td><@timePeriodInput name="thruCustomTimePeriodId" customTimePeriods=customTimePeriods defaultTimePeriodId=defaultThru/></td>
    </tr>
  </table>
</#macro>

<#-- A drop down of GL Fiscal Types -->
<#macro glFiscalTypeInput name glFiscalTypes glFiscalTypeIdToMatch="">
  <@inputSelect name=name list=glFiscalTypes key="glFiscalTypeId" displayField="description" default=glFiscalTypeIdToMatch />
</#macro>

<#macro glFiscalTypeInputRow glFiscalTypes glFiscalTypeIdToMatch="">
  <div style="margin-left: 30px; margin-top: 5px;">
    <span class="tableheadtext">${uiLabelMap.FinancialsGlFiscalType}</span>
    <@glFiscalTypeInput name="glFiscalTypeId" glFiscalTypes=glFiscalTypes/>
  </div>
</#macro>

<#macro compareGlFiscalTypeInputRow glFiscalTypes defaultGlFiscalTypeId1="" defaultGlFiscalTypeId2="">
  <div style="margin-left: 30px; margin-top: 5px;">
    <span class="tableheadtext">${uiLabelMap.FinancialsCompareGlFiscalType}</span>
    <@glFiscalTypeInput name="glFiscalTypeId1" glFiscalTypes=glFiscalTypes glFiscalTypeIdToMatch=getDefaultValue("glFiscalTypeId1", defaultGlFiscalTypeId1) />
    <span class="tableheadtext">${uiLabelMap.CommonTo}</span>
    <@glFiscalTypeInput name="glFiscalTypeId2" glFiscalTypes=glFiscalTypes glFiscalTypeIdToMatch=getDefaultValue("glFiscalTypeId2", defaultGlFiscalTypeId2) />
  </div>
</#macro>

<#macro isPostedInputRow default="" >
  <div style="margin-left: 30px; margin-top: 5px;">
    <span class="tableheadtext">${uiLabelMap.FinancialsIsPosted}</span>
    <select class="selectBox" name="isPosted" size="1">
      <option value="Y">Y</option>
      <option value="N" <#if default?default("Y") == "N">selected="selected"</#if> >N</option>
    </select>
  </div>
</#macro>

<#macro accountingTagsInputs tagTypes>
  <#list tagTypes as tag>
    <div style="margin-left: 30px; margin-top: 5px;">
      <span class="tableheadtext">${tag.description}</span>
      <@inputSelect name="tag${tag.index}" list=tag.tagValues key="enumId" required=true ; tagValue>
        ${tagValue.description}
      </@inputSelect>
    </div>
  </#list>
</#macro>

<#macro submitReportOptions reportRequest="" screenRequest="" returnPage="" returnLabel="">
  <div style="margin-left: 30px; margin-top: 10px;">
    <@inputHidden name="type" value="pdf"/>
    <#if reportRequest?has_content && screenRequest?has_content>
      <@selectAction name="reportAction" prompt="${uiLabelMap.OpentapsRunReportIn}">
        <@action url="javascript: doSubmit('${screenRequest}', 'screen')" text="${uiLabelMap.OpentapsReportOptionScreen}"/>
        <@action url="javascript: doSubmit('${reportRequest}', 'pdf')" text="${uiLabelMap.OpentapsReportOptionPdf}"/>
        <@action url="javascript: doSubmit('${reportRequest}', 'xls')" text="${uiLabelMap.OpentapsReportOptionXls}"/>
      <#if returnPage?has_content && returnLabel?has_content>
        <@action url="javascript: void()" text="${uiLabelMap.OpentapsDefaultActionSeparator}"/>
        <@action url="javascript: window.location.href='/financials/control/${returnPage}'" text="${uiLabelMap.get(returnLabel)}"/>
      </#if>              
      </@selectAction>
    <#else>
      <input type="Submit" class="smallSubmit" name="submitButton" value="${uiLabelMap.CommonRun}"/>
      <#if returnPage?has_content && returnLabel?has_content>
        <input type="button" class="smallSubmit" name="backButton" value="${uiLabelMap.get(returnLabel)}" onClick="window.location.href='/financials/control/${returnPage}'"/>
      </#if>
    </#if>
  </div>  
</#macro>
