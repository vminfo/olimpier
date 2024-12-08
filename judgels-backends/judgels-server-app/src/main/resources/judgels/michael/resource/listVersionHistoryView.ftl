<#-- @ftlvariable type="judgels.michael.resource.ListVersionHistoryView" -->

<#import "/judgels/michael/template/templateLayout.ftl" as template>
<#import "/judgels/michael/ui.ftl" as ui>

<@template.layout>
  <#list versions as version>
    <div class="panel panel-default">
      <div class="panel-heading">
        <span class="panel-title">
          <#if profilesMap[version.userJid]??>${profilesMap[version.userJid].username}<#else>${version.userJid}</#if>
          <small>@ ${getFormattedDurationFromNow(version.time)}</small>
        </span>
        <span class="panel-title pull-right">
          <#if (version?index > 0 && isClean)>
            &nbsp;<@ui.buttonLink intent="danger" size="xs" to="history/${version.hash}/restore">Restore</@ui.buttonLink>
          </#if>
        </span>
        <span class="panel-title pull-right">
          <small>${version.time?datetime?string.long}</small>
        </span>
      </div>
      <div class="panel-body content-text">
        <span class="pull-right"><small>${version.hash?substring(0, 7)}</small></span>
        <#noautoesc>
          ${version.description?esc?markup_string?replace("\r\n", "<br>")?replace("\n", "<br>")}
        </#noautoesc>
      </div>
    </div>
  </#list>
</@template.layout>
