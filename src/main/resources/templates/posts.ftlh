[#ftl]

[#list posts.content]
[#items as post]
<h2><a href="/${post.slug}">${post.title}</a></h2>
<div>${post.author}</div>
<div>${post.published}</div>
<div>${post.perex?no_esc}</div>
[/#items]
[#else]
<p class="fst-italic">Seznam článků je prázdný.</p>
[/#list]


