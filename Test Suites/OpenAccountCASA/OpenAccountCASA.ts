<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>OpenAccountCASA</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>20</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>8e89d3bd-b72c-424a-8af8-4d810f622685</testSuiteGuid>
   <testCaseLink>
      <guid>dca5722c-d5a5-4514-a3d5-b983813985fa</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>4b2a7e05-b5bd-489b-bca7-bd94bee0d92c</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/OpenAccountCASA/LoginInformation</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>4b2a7e05-b5bd-489b-bca7-bd94bee0d92c</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>URL</value>
         <variableId>34f233a4-6ace-4ddd-a9aa-d430b2327f5b</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>4b2a7e05-b5bd-489b-bca7-bd94bee0d92c</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Username</value>
         <variableId>b765a217-c495-4ae5-bbee-f75f5600819c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>4b2a7e05-b5bd-489b-bca7-bd94bee0d92c</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>1ba0032d-3e79-41ba-9ea6-2e90af5747d9</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>920050e5-c7e6-4fe9-ab7f-2d1e5ca1129d</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/DataPreparation/OpenAccountCASA</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>95975648-eb8d-47ca-b472-280641e63456</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/OpenAccountCASA/CustomerProductID</testDataId>
      </testDataLink>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>ae3c0c2f-92bf-46d3-8557-1b6e5b86c2a4</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/OpenAccountCASA/InputTestData</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>95975648-eb8d-47ca-b472-280641e63456</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Customer</value>
         <variableId>5ba8466b-4199-4208-9779-48526ffbfe31</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>95975648-eb8d-47ca-b472-280641e63456</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Joint Account</value>
         <variableId>7a27e6e5-94dd-49f5-8418-0cf679a34e8f</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>95975648-eb8d-47ca-b472-280641e63456</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Sub Product</value>
         <variableId>38078aea-3c1e-4b82-989d-b8a2b2d5f16e</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>95975648-eb8d-47ca-b472-280641e63456</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Currency</value>
         <variableId>3bdb517e-2876-4434-81d0-6ee626f3b395</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>95975648-eb8d-47ca-b472-280641e63456</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Product ID</value>
         <variableId>53cf4099-68bc-4d92-a789-f2af7c4ddc15</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>ae3c0c2f-92bf-46d3-8557-1b6e5b86c2a4</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Limit Indicator</value>
         <variableId>ccae6425-cd19-4b0b-8703-f9355cf4aef7</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>ae3c0c2f-92bf-46d3-8557-1b6e5b86c2a4</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Passbook</value>
         <variableId>ff056d6a-28c6-48be-93b6-ed595104f540</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>25af4192-aa4e-4e71-8e5c-ecec1014bc67</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/LogOutFromSystem</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>dba4cf67-0131-4676-829e-8e8da12c86ae</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>7d01d99c-1c42-4392-91ec-badca034360e</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/OpenAccountCASA/ApprovalOpenAccountCASA</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>7d01d99c-1c42-4392-91ec-badca034360e</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Url</value>
         <variableId>34f233a4-6ace-4ddd-a9aa-d430b2327f5b</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>7d01d99c-1c42-4392-91ec-badca034360e</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Username</value>
         <variableId>b765a217-c495-4ae5-bbee-f75f5600819c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>7d01d99c-1c42-4392-91ec-badca034360e</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>1ba0032d-3e79-41ba-9ea6-2e90af5747d9</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>cb3e42a0-6fcb-47e4-b48e-871919ad53e9</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/DataPreparation/ApprovalDataPreparation</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>ce3928f3-2ac7-453e-bcc9-5b759a489b46</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/OpenAccountCASA/ApprovalOpenAccountCASA</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>ce3928f3-2ac7-453e-bcc9-5b759a489b46</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Description</value>
         <variableId>daf7ff57-af32-47ce-a063-57383e859191</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>a48ae7ce-8e7e-4ea7-ab2e-739c0aa26a38</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>7bdbfeeb-9b2f-4584-b3c1-64d80fe0e053</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/OpenAccountCASA/ConfirmOpenAccountCASA</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>7bdbfeeb-9b2f-4584-b3c1-64d80fe0e053</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Url</value>
         <variableId>34f233a4-6ace-4ddd-a9aa-d430b2327f5b</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>7bdbfeeb-9b2f-4584-b3c1-64d80fe0e053</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Username</value>
         <variableId>b765a217-c495-4ae5-bbee-f75f5600819c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>7bdbfeeb-9b2f-4584-b3c1-64d80fe0e053</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>1ba0032d-3e79-41ba-9ea6-2e90af5747d9</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>a96c5d08-713b-42da-9f2a-01583678eeca</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/DataPreparation/ConfirmDataPreparation</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>a530c089-defc-4084-8237-74a7f86c694c</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Data_Preparation/OpenAccountCASA/ConfirmOpenAccountCASA</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>a530c089-defc-4084-8237-74a7f86c694c</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Description</value>
         <variableId>b162de28-b84f-4d4b-bc20-3d0647e04052</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
