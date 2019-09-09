
<div class="card-columns">
    <#list movies as movie>
        <div class="card mb-4" style="max-width: 730px;">
            <div class="row no-gutters">
                <div class="col-md-4">
                    <#if movie.filename??>
                        <img src="/img/${movie.filename}" class="card-img-top">
                    </#if>
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">${movie.title}</h5>
                        <span class="card-text">Режиссёр: ${movie.directorName}</span>
                        <span class="card-text">Год: ${movie.year}</span>
                        <span class="card-text">Жанр: <#list movie.genres as genre>${genre}<#sep>, </#list></span>
                        <div class="text-center">
                            <a class="btn btn-secondary"
                               data-toggle="collapse"
                               href="#collapse${movie.id}"
                               role="button" aria-expanded="false"
                               aria-controls="collapseExample">
                                Описание
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="collapse text-justify m-2" id="collapse${movie.id}">
                <i class="card-text">${movie.description}</i>
            </div>
        </div>
    <#else>
        No movies
    </#list>
</div>
