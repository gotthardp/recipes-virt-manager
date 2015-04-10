DESCRIPTION = "Backport of the subprocess module from Python 3.2/3.3 for use on 2.x."
HOMEPAGE = "https://docs.python.org/3.2/library/subprocess.html"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d3e62baa8fb96b11a59d3f2cd335d5c0"
PR = "r0"

SRC_URI = "https://pypi.python.org/packages/source/s/subprocess32/subprocess32-${PV}.tar.gz"
S = "${WORKDIR}/subprocess32-${PV}"

inherit distutils

SRC_URI[md5sum] = "754c5ab9f533e764f931136974b618f1"
SRC_URI[sha256sum] = "ddf4d46ed2be2c7e7372dfd00c464cabb6b3e29ca4113d85e26f82b3d2c220f6"
