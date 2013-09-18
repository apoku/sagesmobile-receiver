#from django.conf.urls.defaults import *
from django.conf.urls import *


# Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Example:
    # (r'^rapidandroiddb/', include('rapidandroiddb.foo.urls')),

    # Uncomment the next line to enable admin documentation:
     (r'^admin/doc/', include('django.contrib.admindocs.urls')),
	url(r'^admin/', include(admin.site.urls)),
    # Uncomment the next line for to enable the admin:
    #(r'^admin/(.*)', admin.site.root),
)
