<#-- @ftlvariable type="judgels.michael.lesson.NewLessonView" -->

<#import "/judgels/michael/template/templateLayout.ftl" as template>
<#import "/judgels/michael/forms.ftl" as forms>

<@template.layout>
  <@forms.form>
    <@forms.input name="slug" label="Slug" required=true autofocus=true pattern="[a-z0-9]+(-[a-z0-9]+)*" title="Slug can only consist of alphanumerics and dashes"/>
    <@forms.textarea name="additionalNote" label="Additional note"/>
    <@forms.select name="initialLanguage" label="Initial language" options=languages/>
    <@forms.submit>Create</@forms.submit>
  </@forms.form>
</@template.layout>
