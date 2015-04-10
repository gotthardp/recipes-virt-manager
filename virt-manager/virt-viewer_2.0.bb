SUMMARY = "Virtual Machine Viewer"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

# glib-2.0 for glib-gettext.m4 which provides AM_GLIB_GNU_GETTEXT
DEPENDS = "glib-2.0 gtk+ gtk-vnc libxml2 libvirt"

SRC_URI = "http://virt-manager.org/download/sources/virt-viewer/${BP}.tar.gz"

SRC_URI[md5sum] = "4b1e9a2029e0dfff741e17bb915f75ec"
SRC_URI[sha256sum] = "e9c583bcb5acdabac6a8a13eff6ce4e093a3050645771628f832e15ce685d437"

EXTRA_OECONF += "--with-gtk=2.0 --disable-update-mimedb"

inherit autotools pkgconfig

FILES_${PN} += "/usr/share/icons/* /usr/share/mime/*"
