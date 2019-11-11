<#import "parts/common.ftl" as c>
<#import "parts/movies.ftl" as m>

<@c.page>
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="title" placeholder="Введите название" />
            </div>
            <div class="form-group">
                <input type="number" class="form-control" name="year" placeholder="Введите год">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="directorName" placeholder="Введите имя режиссёра">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="genres" placeholder="Введите жанры">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="description" placeholder="Описание">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Загрузить постер</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</@c.page>