$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/feature/Login.feature");
formatter.feature({
  "name": "Login",
  "description": " In order to buy the product in webpage\n As a customer\n I want to get access to the portal",
  "keyword": "Feature"
});
formatter.background({
  "name": "Below are the common steps for the scenarios",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I have browser with productstore page.",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cts.stepdefinition.StepDefinition.i_have_browser_with_productstore_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Filling all the userdetails and click on close",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I enter the useer name as \u0027hema\u0027 and country as \u0027India\u0027 and city as \u0027chirala\u0027 and credit card as \u0027605385697632\u0027 and month as \u0027nov\u0027 and year as \u00272022\u0027 and click on purchase order and click on close",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "It should go back to the cartpage and assert for \u0027Place Order\u0027",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});