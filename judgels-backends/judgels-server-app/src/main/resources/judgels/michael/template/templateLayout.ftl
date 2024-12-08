<#-- @ftlvariable type="judgels.michael.template.TemplateView" -->

<#import "base/baseLayout.ftl" as base>
<#import "base/columnLayout.ftl" as column>
<#import "content/contentLayout.ftl" as content>
<#import "content/mainTabsView.ftl" as mainTabs>
<#import "content/mainWarningView.ftl" as mainWarning>
<#import "content/secondaryTabsView.ftl" as secondaryTabs>
<#import "content/titleView.ftl" as title>
<#import "base/headerView.ftl" as header>
<#import "base/footerView.ftl" as footer>
<#import "base/formErrorView.ftl" as formError>

<#macro layout>
  <@base.layout title=vars.title>
    <@header.view name=vars.name username=vars.username avatarUrl=vars.avatarUrl/>
    <main class="container">
      <@column.layout
        sidebarMenus=vars.sidebarMenus
        activeSidebarMenu=vars.activeSidebarMenu
        searchProblemsWidget=vars.searchProblemsWidget
        searchLessonsWidget=vars.searchLessonsWidget
      >
        <@content.layout>
          <@title.view title=vars.title buttons=vars.mainButtons/>
          <@mainWarning.view html=vars.mainWarningHtml/>
          <@mainTabs.view tabs=vars.mainTabs activeTab=vars.activeMainTab/>
          <@secondaryTabs.view tabs=vars.secondaryTabs activeTab=vars.activeSecondaryTab/>
          <@formError.view message=(formValues.globalError)!""/>
          <#nested>
        </@content.layout>
      </@column.layout>
    </main>
    <@footer.view/>
  </@base.layout>
</#macro>
