# LightningJava
Set of Java classes in development to connect to a c-lightning node. Use <a href="https://github.com/ElementsProject/lightning/pull/2223">JLightning</a> Library created by Rene Pickhardt. 

All the credits for Rene. The supported version of c-lightning is v0.7.0-1-g0631490. 

The project can be run as a standalone application or as a simplified interface on top of the c-lightning that facilitates and exposes lightning functionalities to client applications. 

# Dependencies
JLightning uses <a href="https://github.com/kohlschutter/junixsocket">Junixsocket</a>. A Java/JNI library that allows the use of Unix Domain Sockets (AF_UNIX sockets) from Java.

# Using Lightning Java
<code>ubuntu@vmi214216:/var/www/twitter$ java JLightning
{
  "num_inactive_channels": 0,
  "address": [{
    "address": "192.168.0.157",
    "port": 9735,
    "type": "ipv4"
  }],
  "color": "028306",
  "fees_collected_msat": "636msat",
  "version": "v0.7.0-1-g0631490",
  "blockheight": 572019,
  "network": "bitcoin",
  "num_pending_channels": 3,
  "num_peers": 26,
  "msatoshi_fees_collected": 636,
  "num_active_channels": 23,
  "alias": "mainnet.clobig.com",
  "id": "0283065d6d5b1fbeaa1f21e62755b4b834c4fabd2765d9522f5a79ec216fec3013"
}
</code>
