<#import "parts/common.ftl" as c>
<#import "parts/movies.ftl" as m>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Поиск по названию">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <#include "parts/movies.ftl">
</@c.page>