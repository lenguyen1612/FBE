<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>QuickPartyOnboardingEnterprise</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>20</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>c8e6d421-87e1-4ee0-ac97-b318a9bbfa73</testSuiteGuid>
   <testCaseLink>
      <guid>dd430cc8-3827-42a0-a095-3dffdcb5e938</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login</testCaseId>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>34f233a4-6ace-4ddd-a9aa-d430b2327f5b</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>b765a217-c495-4ae5-bbee-f75f5600819c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>1ba0032d-3e79-41ba-9ea6-2e90af5747d9</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>8691e7e1-76d8-499f-a019-7dce197ec770</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>c1a648a9-47b9-48be-a740-0300edb7388b</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/DataPreparation/QuickPartyOnboardingEnterprise</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/QuickPartyEnterprise/EnterpriseInformation</testDataId>
      </testDataLink>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>90754889-1c7b-4eaa-82c6-c6d872b2e647</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/QuickPartyEnterprise/PartyOnboarding</testDataId>
      </testDataLink>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>f48f46b2-b359-409e-b3b6-d86fad85c6d9</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/QuickPartyEnterprise/PreExistCheck</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>90754889-1c7b-4eaa-82c6-c6d872b2e647</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Local/Global</value>
         <variableId>494ef7b5-87b5-46ec-a8bc-e732e7af385c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>90754889-1c7b-4eaa-82c6-c6d872b2e647</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Party Type</value>
         <variableId>332c26cd-cf6a-46b6-955d-e99317d0a37c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>90754889-1c7b-4eaa-82c6-c6d872b2e647</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Party Sub-Type</value>
         <variableId>90a56946-b66c-4fb5-bef8-08fc52561367</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>90754889-1c7b-4eaa-82c6-c6d872b2e647</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Party Category</value>
         <variableId>f0b486c4-2390-43f7-beef-a987328c45fe</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>90754889-1c7b-4eaa-82c6-c6d872b2e647</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Line of Business</value>
         <variableId>08a3407a-eee8-4a68-8362-706ed29d9d93</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f48f46b2-b359-409e-b3b6-d86fad85c6d9</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Enterprise name</value>
         <variableId>192fe485-5890-427b-8c57-20d7fc57031b</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f48f46b2-b359-409e-b3b6-d86fad85c6d9</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Registered number</value>
         <variableId>721329b1-6c0f-4757-959f-ea6c05f3a4a0</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f48f46b2-b359-409e-b3b6-d86fad85c6d9</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Goods &amp; services tax registered number</value>
         <variableId>2a60fd0f-ec8e-430b-ac32-efa7f47bb97d</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f48f46b2-b359-409e-b3b6-d86fad85c6d9</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Email/ Contact Number</value>
         <variableId>ab16bcc8-6f42-4b13-b55a-12a7d6094a40</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Registered Number</value>
         <variableId>46f20a21-c949-4c45-bb0c-921b575e201f</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Short Name</value>
         <variableId>5dc15786-e066-4809-8ae2-e5814cca15a9</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Adderss Type</value>
         <variableId>3a531f66-af1c-4370-970b-8489c058b2ec</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Country Region</value>
         <variableId>507836cc-f491-43ff-9f33-7651d7133735</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Post Code</value>
         <variableId>02d2c1ea-2187-4867-a120-dbdc16b5999a</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Contact Type Email</value>
         <variableId>a56e90f0-9872-488a-ba6f-01d477ce0f1e</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Email</value>
         <variableId>1da6724d-3023-48de-b975-864851b32ddc</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Contact Type Email</value>
         <variableId>ecf2b630-867c-44be-b3af-aedd7b68e709</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Contact Type Mobile</value>
         <variableId>ab3bd019-dc8f-407d-950b-f79c17cfced3</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Country Code</value>
         <variableId>c12292bc-1e30-4f39-915b-40ade3709044</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Number</value>
         <variableId>51bf4c54-7e29-4784-8135-b1d6271c563e</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f34a1768-ce3a-4d3c-990b-5ee4188fbe15</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Document Collection Status</value>
         <variableId>d675ab8c-3c6d-4ead-b7bd-a9b8c14ba6b7</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>f1b9d887-e5d0-41b9-873b-895fd21c7752</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>false</isRun>
      <testCaseId>Test Cases/LogOutFromSystem</testCaseId>
   </testCaseLink>
</TestSuiteEntity>
