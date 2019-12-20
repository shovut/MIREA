from django.urls import path

from all.views import Resp

urlpatterns = [
    path('get/', Resp.getall),
    path('delete/', Resp.removebyid),
]